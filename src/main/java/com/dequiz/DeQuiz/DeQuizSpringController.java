package com.dequiz.DeQuiz;


import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dequiz.DeQuiz.dto.DeQuizMaster;
import com.dequiz.DeQuiz.dto.DeQuizUser;
import com.dequiz.DeQuiz.repo.DeQuizMasterDBRepo;
import com.dequiz.DeQuiz.repo.DeQuizUserDBRepo;

@Controller
public class DeQuizSpringController {
	

	@Autowired
	DeQuizUserDBRepo deQuizUserRepo;
	
	@Autowired
	DeQuizMasterDBRepo deQuizMasterRepo;
	
	@RequestMapping("/")
	private String home() {
		System.out.println("Going home....");
		return "index";
	}

	@GetMapping("/joinQuiz")
	private String showForm(@Valid Model model) {
		DeQuizUser deQuizUser = new DeQuizUser();
		model.addAttribute("deQuizUser", deQuizUser);
		return "register_form";
	}


	@PostMapping("/joinQuiz")
	public String submitForm(@Valid @ModelAttribute("deQuizUser") DeQuizUser deQuizUser, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "register_form";
		} else {
			deQuizUser.setDquSessionId("Dummy session id");
			deQuizUser.setDquAnswer("X");
			deQuizUser.setDquMarks(0);
			deQuizUser.setDquTotalMarks(0);
			deQuizUser.setDquQuestionNo(0);
			deQuizUser.setDquTotalMarks(0);
			model.addAttribute("user", deQuizUser);
			deQuizUserRepo.save(deQuizUser);
			return "registerok";

		}
	}

	
	
	/* startquiz requires userId, quizId and questionNo*/
	@PostMapping("/startquiz")
	private String showQuiz(@ModelAttribute("deQuizUser") DeQuizUser deQuizUser,Model model) {
		System.out.println("inside startquiz get: " + deQuizUser);
		Integer quizId = deQuizUser.getDquQuizId() * 100 + deQuizUser.getDquQuestionNo() + 1;
			
		DeQuizMaster deQuizMaster = new DeQuizMaster ();
	
		Optional<DeQuizMaster> deQuizMasterMap = deQuizMasterRepo.findById(quizId);
		if (!deQuizMasterMap.isPresent()){
			Optional <DeQuizUser> deQuizUserMap = deQuizUserRepo.findById(deQuizUser.getDquUserId());
			if(deQuizUserMap.isPresent()) {
				deQuizUser = deQuizUserMap.get();
				model.addAttribute("deQuizUser",deQuizUser);
			}
			return "finalresult";
		}
	
		deQuizMaster = deQuizMasterMap.get();
		deQuizMaster.setDquUserId(deQuizUser.getDquUserId());
		model.addAttribute("deQuizMaster",deQuizMaster);
		return "startquiz";
	}
	
/*  showresult needs 4 parameters - quizId, questionNo, answer and userId*/
	@PostMapping("/showresult")
	private String showResult(@ModelAttribute("deQuizMaster") DeQuizMaster deQuizMaster, Model model){
		System.out.println("Correct Ans: " +deQuizMaster.getDeqmAnswer() + " Selected:" + deQuizMaster.getSelectedAnswer());
		
		DeQuizUser deQuizUser = new DeQuizUser();
		Optional<DeQuizUser> deQuizUserMap = deQuizUserRepo.findById(deQuizMaster.getDquUserId());
		if (!deQuizUserMap.isPresent()){
			return "error";
		}
		deQuizUser = deQuizUserMap.get();
		deQuizUser.setDquQuestionNo(deQuizMaster.getDeqmQuestionNo());
		deQuizUser.setDquMarks(0);
		if(deQuizMaster.getDeqmAnswer().equals(deQuizMaster.getSelectedAnswer())) {
			System.out.println("adding marks " + deQuizMaster.getDquMarks());
			deQuizUser.setDquMarks(deQuizMaster.getDquMarks());
			deQuizUser.setDquTotalMarks(deQuizUser.getDquTotalMarks()+deQuizUser.getDquMarks());
			deQuizUserRepo.save(deQuizUser);	
		}
		model.addAttribute("deQuizUser",deQuizUser);
		return "showresult";
	}

}
