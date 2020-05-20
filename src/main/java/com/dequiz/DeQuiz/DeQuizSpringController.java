package com.dequiz.DeQuiz;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dequiz.DeQuiz.DeQuizUserDBRepo;
@Controller
public class DeQuizSpringController {
	
	@RequestMapping("/")
	private String home() {
		System.out.println("Going home....");
		return "index";
	}
	@GetMapping("/joinQuiz")
	private String showForm(@Valid Model model) {
		DeQuizUser user = new DeQuizUser();
		model.addAttribute("user", user);
		return "register_form";
	}
	@Autowired
	DeQuizUserDBRepo userRepo;
	@PostMapping("/joinQuiz")
	public String submitForm(@Valid @ModelAttribute("user") DeQuizUser user,
								BindingResult bindingResult,HttpSession session) {
		System.out.println(user);
		String usersession = session.getId();
		if(bindingResult.hasErrors()) {
			return "register_form";
		}
		else {
			user.setDquSessionId(usersession);
			user.setDquAnswer("");
			user.setDquMarks(0); 
			user.setDquTotalMarks(0);
			userRepo.save(user);
		return "register_success";
		
		}
	}
	@GetMapping("/startQuiz")
	private String showQuiz(Model model) {
		Quiz quiz = new Quiz();
		model.addAttribute("quiz", quiz);
		return "start_quiz";
	}
	
	
	
	@PostMapping("/getResult")
	private String showResult(@ModelAttribute("quiz") Quiz quiz) {
		if (quiz.getQuestion().equalsIgnoreCase("optionA")) {
		return "quiz_result_pass";
		} else
		{
		return "quiz_result_fail";	
		}
	}
	

}
