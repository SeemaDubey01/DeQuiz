package com.dequiz.DeQuiz;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dequiz.DeQuiz.dto.DeQuizLogin;


@Controller
public class DeQuizAdminController {
	@RequestMapping("/admin")
	private String admin() {
		System.out.println("Going admin....");
		return "admin";
	}
	
	@GetMapping("/adminlogin")
	private String showForm(@Valid Model model) {
		DeQuizLogin deQuizLogin = new DeQuizLogin();
		model.addAttribute("deQuizLogin", deQuizLogin);
		return "adminLogin";
	}
	
	@PostMapping("/loginadmin")
	public String submitForm(@Valid @ModelAttribute("deQuizLogin") DeQuizLogin deQuizLogin, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("The error coming here is "+bindingResult.getGlobalError());
			return "adminLogin";
		} else {
			model.addAttribute("deQuizLogin", deQuizLogin);
			return "adminregisterok";

		}
	}

}
