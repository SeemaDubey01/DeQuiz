 package com.dequiz.DeQuiz;

import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dequiz.DeQuiz.dto.DeQuizLogin;
import com.dequiz.DeQuiz.repo.DeQuizLoginDBRepo;


@Controller
public class DeQuizAdminController {
	
	@Autowired
	DeQuizLoginDBRepo deQuizLoginDBRepo;
	

	DeQuizLogin quizLogin;
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
		if(deQuizLogin.getDqlUserId()!=null) {
			DeQuizLogin dequizlogin = getAdmin(deQuizLogin.getDqlUserId());
			
			if (dequizlogin==null) {
				bindingResult.addError(new FieldError("deQuizLogin", "dqlUserId", "User id/password is incorrect"));
			}
			if (dequizlogin!=null && deQuizLogin!=null && !dequizlogin.getDqlPassword().equals(deQuizLogin.getDqlPassword())) {
				System.out.println("Inside the password check");
				bindingResult.addError(new FieldError("deQuizLogin", "dqlUserId", "User id/password is incorrect"));
			}
		}
		if (bindingResult.hasErrors()) {
			return "adminLogin";
		} else {
			model.addAttribute("deQuizLogin", deQuizLogin);
			return "adminregisterok";

		}
	}
	
	@GetMapping("/signUpNew")
	private String showSignUpForm(Model model) {
		System.out.println("Inside the get method--rtertertrt-");
		DeQuizLogin deQuizLogin = new DeQuizLogin();
		model.addAttribute("deQuizLogin", deQuizLogin);
		return "adminSignUp";
	}
	
	@PostMapping("/saveAdmin")
	public String saveAdmin(@Valid @ModelAttribute("deQuizLogin") DeQuizLogin deQuizLogin, BindingResult bindingResult, Model model) {
		if(deQuizLogin.getDqlUserId()!=null) {
			DeQuizLogin dequizlogin = getAdmin(deQuizLogin.getDqlUserId());;
			if (dequizlogin!=null && dequizlogin.getDqlUserId().equalsIgnoreCase(deQuizLogin.getDqlUserId())) {
				System.out.println("userid exists");
				bindingResult.addError(new FieldError("deQuizLogin", "dqlUserId", "UserId already exists please select a new userId"));
			}
		}
		
		if (bindingResult.hasErrors()){
			return "adminSignUp";
		} 
	
		else {
			model.addAttribute("deQuizLogin", deQuizLogin);
			deQuizLoginDBRepo.save(deQuizLogin);
			return "adminregisterok";

		}
	}
	
	 private DeQuizLogin getAdmin(String userIdfield){
		  System.out.println("Inside getAdmin"); 
		  Optional<DeQuizLogin> dequizLoginMap =deQuizLoginDBRepo.findById(userIdfield); 
		  if(dequizLoginMap.isPresent()) { 
			  quizLogin = dequizLoginMap.get();
		  } 
		  return quizLogin;
		  
		  }

}
