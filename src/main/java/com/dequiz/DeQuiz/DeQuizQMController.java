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
		Random random = new Random();
		int quizId = 100+random.nextInt(999-100);
		quizmaster.setDeqmQuizId(quizId);
		quizmaster.setDqlUserId(deQuizLogin.getDqlUserId());
		System.out.println("the object which comes here in master is"+quizmaster.getDqlUserId());
		model.addAttribute("quizmaster", quizmaster);
		return"createquizHeader";
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

}

