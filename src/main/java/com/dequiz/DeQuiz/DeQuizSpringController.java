package com.dequiz.DeQuiz;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.sql.*;
@Controller
public class DeQuizSpringController {
	
	@RequestMapping("/")
	private String home() {
		System.out.println("Going home....");
		return "index";
	}
	@GetMapping("/joinQuiz")
	private String showForm(@Valid Model model) {
		UserDetail user = new UserDetail();
		model.addAttribute("user", user);
		return "register_form";
	}
	
	@PostMapping("/joinQuiz")
	public String submitForm(@Valid @ModelAttribute("user") UserDetail user,
								BindingResult bindingResult) {
		System.out.println(user);
		if(bindingResult.hasErrors()) {
			return "register_form";
		}
		else {
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
