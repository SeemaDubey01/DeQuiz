package com.dequiz.DeQuiz;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dequiz.DeQuiz.dto.DeQuizMaster;
import com.dequiz.DeQuiz.repo.DeQuizMasterDBRepo;


@Controller
public class DeQuizQMController {
	@Autowired
	DeQuizMasterDBRepo dequizMasterrepo;
	
	@GetMapping("/createquiz")
	private String CrateQuiz(@ModelAttribute("quizmaster") DeQuizMaster quizmaster, Model model) {
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

