package com.dequiz.DeQuiz;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dequiz.DeQuiz.dto.DeQuizLogin;
import com.dequiz.DeQuiz.dto.DeQuizMaster;
import com.dequiz.DeQuiz.repo.DeQuizMasterDBRepo;


@Controller
public class DeQuizQMController {
	@Autowired
	DeQuizMasterDBRepo dequizMasterrepo;
	
	@GetMapping("/createquizHeader")
	private String createQuizHeader(@ModelAttribute("deQuizLogin") DeQuizLogin deQuizLogin, Model model) {
		System.out.println("the  model here is---"+model);
		System.out.println("the object which comes here is"+deQuizLogin.getDqlUserId());
		DeQuizMaster quizmaster = new DeQuizMaster();
		quizmaster.setDqlUserId(deQuizLogin.getDqlUserId());
		System.out.println("the object which comes here in master is"+quizmaster.getDqlUserId());
		model.addAttribute("quizmaster", quizmaster);
		return"createquizHeader";
	}
	
	@PostMapping("/createquizDetail")
	private String postQuizHeader(@ModelAttribute("quizmaster") DeQuizMaster quizmaster, Model model) {
		System.out.println("The admi created the quiz is---"+quizmaster.getDqlUserId());
		System.out.println("The description of the quiz is"+quizmaster.getDeqmQuizDesc());
		quizmaster.setDeqmSrNbr(00);
		quizmaster.setDeqmQuestion("");
		quizmaster.setDeqmOption_a("");
		quizmaster.setDeqmOption_b("");
		quizmaster.setDeqmOption_c("");
		quizmaster.setDeqmOption_d("");
		quizmaster.setDeqmAnswer("");
		quizmaster.setDeqmQuestionNo(00);
		quizmaster.setDeqmQuizId(null);
		quizmaster.setDquMarks(00);
		dequizMasterrepo.save(quizmaster);
		model.addAttribute("quizmaster", quizmaster);
		return "createquizDetail";
	}
	
	@GetMapping("/createquiz")
	private String CrateQuiz(@ModelAttribute("quizmaster") DeQuizMaster quizmaster, Model model) {
		System.out.println("check hidden is working----"+quizmaster.getDeqmQuizActive());
		if (quizmaster.getDeqmQuizId() == null ) {
			Random random = new Random();
			int quizId = 100+random.nextInt(999-100);
			quizmaster.setDeqmQuizId(quizId);
			quizmaster.setDeqmQuestionNo(1);
		} 
		model.addAttribute("quizmaster", quizmaster);
		return "createquiz";
	}

	@PostMapping("/createquizstatus")
	private String CreateQuizStatus(@ModelAttribute("quizmaster") DeQuizMaster quizmaster, Model model) {
	
// insert the quiz into DeQuizMaster table
		Integer quizSrNo = quizmaster.getDeqmQuizId() * 100 + quizmaster.getDeqmQuestionNo();
		
		quizmaster.setDeqmSrNbr(quizSrNo);
		dequizMasterrepo.save(quizmaster);
		quizmaster.nextQustionNo();

		System.out.println("outside create status: " + quizmaster);
		model.addAttribute("quizmaster", quizmaster);
		return "createquizstatus";
	}

}

