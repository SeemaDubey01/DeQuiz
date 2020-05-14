package com.dequiz.DeQuiz;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeQuizSpringController {
	
	@RequestMapping("/")
	private String home() {
		System.out.println("Going home....");
		return "index";
	}
	@GetMapping("/joinQuiz")
	private String showForm(@Valid Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register_form";
	}
	
	@PostMapping("/joinQuiz")
	public String submitForm(@Valid @ModelAttribute("user") User user,
								BindingResult bindingResult) {
		System.out.println(user);
		if(bindingResult.hasErrors()) {
			return "register_form";
		}
		else {
		return "register_success";
		}
	}

}
