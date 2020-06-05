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
/*	
	@RequestMapping("/")
	private String home() {
		System.out.println("Going home....");
		return "index";
	}
*/
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

	
	/* startquiz requires userId, quizId and questionNo */
	@PostMapping("/startquiz")
	private String showQuiz(@ModelAttribute("deQuizUser") DeQuizUser deQuizUser,Model model) {
		System.out.println("inside startquiz get: " + deQuizUser);
		Integer quizId = deQuizUser.getDquQuizId() * 100 + deQuizUser.getDquQuestionNo() + 1;
			
		DeQuizMaster deQuizMaster = new DeQuizMaster ();
	
		Optional<DeQuizMaster> deQuizMasterMap = deQuizMasterRepo.findById(quizId);
		if (!deQuizMasterMap.isPresent()){
			Optional <DeQuizUser> deQuizUserMap = deQuizUserRepo.findById(deQuizUser.getDquUserId());
			if (deQuizUserMap.isPresent()){
				deQuizUser = deQuizUserMap.get();
				System.out.println("final: " + deQuizUser);
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
		switch (deQuizMaster.getDeqmAnswer()) {
		case "a":
		case "A":
			deQuizUser.setDquCorrectAns(deQuizMaster.getDeqmOption_a());
			break;
		case "b":
		case "B":
			deQuizUser.setDquCorrectAns(deQuizMaster.getDeqmOption_b());
			break;
		case "c":
		case "C":
			deQuizUser.setDquCorrectAns(deQuizMaster.getDeqmOption_c());
			break;
		case "d":
		case "D":
			deQuizUser.setDquCorrectAns(deQuizMaster.getDeqmOption_d());
			break;
		default:
			deQuizUser.setDquCorrectAns("Anser not given by Quiz Master");
		}
		if(deQuizMaster.getDeqmAnswer().equalsIgnoreCase(deQuizMaster.getSelectedAnswer())) {
			System.out.println("adding marks " + deQuizMaster.getDquMarks());
			deQuizUser.setDquMarks(deQuizMaster.getDquMarks());
			deQuizUser.setDquTotalMarks(deQuizUser.getDquTotalMarks()+deQuizUser.getDquMarks());
			deQuizUserRepo.save(deQuizUser);	
		}
		model.addAttribute("deQuizUser",deQuizUser);
		return "showresult";
	}
	/*
	@RequestMapping("/aboutUs")
	private String aboutUs() {
		System.out.println("Going aboutUs....");
		return "aboutUs";
	}

	@RequestMapping("/contactUs")
	private String contactUs() {
		System.out.println("Going contactUs....");
		return "contactUs";
	}
	*/

}
