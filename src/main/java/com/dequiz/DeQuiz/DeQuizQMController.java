package com.dequiz.DeQuiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dequiz.DeQuiz.Websocket.WebSocketDAO;
import com.dequiz.DeQuiz.dto.DeQuizLogin;
import com.dequiz.DeQuiz.dto.DeQuizMaster;
import com.dequiz.DeQuiz.repo.DeQuizMasterDBRepo;


@Controller
@SessionAttributes({"deQuizLogin","existingDistinctQuizlist"})
public class DeQuizQMController {
	@Autowired
	DeQuizMasterDBRepo dequizMasterrepo;
	
	@Autowired
	WebSocketDAO wsMessageDAO;
	
	@PostMapping("/createquizHeader")
	private String createQuizHeader(@ModelAttribute("deQuizLogin") DeQuizLogin deQuizLogin, Model model, HttpSession session) {
		System.out.println("The value of selected button is22222222222222222222222 ----"+deQuizLogin.getDqlOperationType());
		String returntype = "";
		String operationType = deQuizLogin.getDqlOperationType();
		if(operationType.equalsIgnoreCase("create")) {
		DeQuizMaster quizmaster = new DeQuizMaster();
		Random random = new Random();
		int quizId = 100+random.nextInt(999-100);
		quizmaster.setDeqmQuizId(quizId);
		quizmaster.setDqlUserId(deQuizLogin.getDqlUserId());
		System.out.println("the object which comes here in master is"+quizmaster.getDqlUserId());
		model.addAttribute("quizmaster", quizmaster);
		returntype ="createquizHeader";
		}
		if(operationType.equalsIgnoreCase("view")) {
			DeQuizMaster deQuizMaster = new DeQuizMaster ();
			List<DeQuizMaster> deQuizMasterList = new ArrayList<DeQuizMaster>();
			deQuizMasterList = dequizMasterrepo.findByDeqmQuizId(deQuizLogin.getDeqmQuizId());
			deQuizMaster = deQuizMasterList.get(1);
			model.addAttribute("operationType", operationType);
			model.addAttribute("deQuizMaster", deQuizMaster);
			returntype = "viewquiz";
		}
		if(operationType.equalsIgnoreCase("edit")) {
			DeQuizMaster deQuizMaster = new DeQuizMaster ();
			List<DeQuizMaster> deQuizMasterList = new ArrayList<DeQuizMaster>();
			deQuizMasterList = dequizMasterrepo.findByDeqmQuizId(deQuizLogin.getDeqmQuizId());
			deQuizMaster = deQuizMasterList.get(1);
			model.addAttribute("operationType", operationType);
			model.addAttribute("deQuizMaster", deQuizMaster);
			returntype = "editquiz";
		}
		if(operationType.equalsIgnoreCase("start")) {
			DeQuizMaster deQuizMaster = new DeQuizMaster ();
			deQuizMaster.setDeqmQuizId(deQuizLogin.getDeqmQuizId());
			wsMessageDAO.setQuizActive(deQuizMaster.getDeqmQuizId());
			model.addAttribute("deQuizMaster", deQuizMaster);
			System.out.println("Admin start quiz");
			returntype = "adminInQuiz";
		}
		if(operationType.equalsIgnoreCase("delete")) {
			Integer id = deQuizLogin.getDeqmQuizId();
			model.addAttribute("quizId", id);
			dequizMasterrepo.deleteByDeqmQuizId(id);
			
			returntype = "adminregisterok";
		}
		return returntype;
		
	}
	
	
	
	@PostMapping("/createquizDetail")
	private String postQuizHeader(@ModelAttribute("quizmaster") DeQuizMaster quizmaster, Model model) {
		System.out.println("The admi created the quiz is---"+quizmaster.getDqlUserId());
		System.out.println("The quiz id22222222222 of the quiz is"+quizmaster.getDeqmQuizId());
		quizmaster.setDeqmSrNbr(quizmaster.getDeqmQuizId()*100);
		quizmaster.setDeqmQuestion("");
		quizmaster.setDeqmOption_a("");
		quizmaster.setDeqmOption_b("");
		quizmaster.setDeqmOption_c("");
		quizmaster.setDeqmOption_d("");
		quizmaster.setDeqmAnswer("");
		quizmaster.setDeqmQuestionNo(00);
		quizmaster.setDquMarks(00);
		
		dequizMasterrepo.save(quizmaster);
		model.addAttribute("quizmaster", quizmaster);
		return "createquizDetail";
	}
	
	@PostMapping("/createquiz")
	private String CrateQuiz(@ModelAttribute("quizmaster") DeQuizMaster quizmaster, Model model) {
		System.out.println("The value of question number coming as---"+quizmaster.getDeqmQuestionNo());
		if (quizmaster.getDeqmQuestionNo() == null ) {
			quizmaster.setDeqmQuestionNo(1);
		} 
		model.addAttribute("quizmaster", quizmaster);
		return "createquiz";
	}

	@PostMapping("/createquizstatus")
	private String CreateQuizStatus(@ModelAttribute("quizmaster") DeQuizMaster quizmaster, Model model) {
		System.out.println("Inside create status---"+quizmaster.getDeqmQuestionNo());
// insert the quiz into DeQuizMaster table
		Integer quizSrNo = quizmaster.getDeqmQuizId() * 100 + quizmaster.getDeqmQuestionNo();
		
		quizmaster.setDeqmSrNbr(quizSrNo);
		dequizMasterrepo.save(quizmaster);
		quizmaster.nextQustionNo();

		System.out.println("outside create status: " + quizmaster);
		model.addAttribute("quizmaster", quizmaster);
		return "createquizstatus";
	}
	
	@PostMapping("/getNextQuestioin")
	private String getNextQuestion(@ModelAttribute("deQuizMaster") DeQuizMaster deQuizMaster, Model model,HttpSession session) {
		Integer quizId = deQuizMaster.getDeqmQuizId() * 100 + deQuizMaster.getDeqmQuestionNo() + 1;
	
		Optional<DeQuizMaster> deQuizMasterMap = dequizMasterrepo.findById(quizId);
		if (!deQuizMasterMap.isPresent()){
			
			return "adminregisterok";
		}
		
	
		deQuizMaster = deQuizMasterMap.get();
		model.addAttribute("deQuizMaster",deQuizMaster);
	
		return "viewquiz";
	}
	@PostMapping("/getNextQuestioinEdit")
	private String getNextQuestionEdit(@ModelAttribute("deQuizMaster") DeQuizMaster deQuizMaster, Model model) {
		if(deQuizMaster.getEditType().equalsIgnoreCase("next")) {
		Integer quizId = deQuizMaster.getDeqmQuizId() * 100 + deQuizMaster.getDeqmQuestionNo() + 1;
		Optional<DeQuizMaster> deQuizMasterMap = dequizMasterrepo.findById(quizId);
		if (!deQuizMasterMap.isPresent()){
			return "adminregisterok";
		}
		deQuizMaster = deQuizMasterMap.get();
		model.addAttribute("deQuizMaster",deQuizMaster);
	
		return "editquiz";
		}
		if(deQuizMaster.getEditType().equalsIgnoreCase("save")) {
			System.out.println("The id of the question is----"+deQuizMaster.getDeqmSrNbr());
			System.out.println("Values inside object"+deQuizMaster.getDeqmOption_c()+" And option d is"+deQuizMaster.getDeqmOption_d());
			dequizMasterrepo.save(deQuizMaster);
			model.addAttribute("deQuizMaster", deQuizMaster);
			return "editquiz";
		}
		if(deQuizMaster.getEditType().equalsIgnoreCase("previous")){
			Integer quizId = deQuizMaster.getDeqmQuizId() * 100 + deQuizMaster.getDeqmQuestionNo() - 1;
			Optional<DeQuizMaster> deQuizMasterMap = dequizMasterrepo.findById(quizId);
			if (!deQuizMasterMap.isPresent()){
				return "allQuestions";
			}
			deQuizMaster = deQuizMasterMap.get();
			model.addAttribute("deQuizMaster",deQuizMaster);
		
			return "editquiz";
			}
		return "editquiz";
	}
	
	@GetMapping("/getUserQuizList")
	private String getUserQuizList(Model model) {
	
			return "adminregisterok";
		
	}

}

