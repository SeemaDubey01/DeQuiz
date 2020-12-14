 package com.dequiz.DeQuiz.Controller;

import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dequiz.DeQuiz.DTO.DeQuizLogin;
import com.dequiz.DeQuiz.DTO.DeQuizMaster;
import com.dequiz.DeQuiz.Repo.DeQuizLoginDBRepo;
import com.dequiz.DeQuiz.Repo.DeQuizMasterDBRepo;
import com.dequiz.DeQuiz.Servie.DeQuizDBService;


@Controller
@SessionAttributes({"deQuizLogin","existingDistinctQuizlist"})
public class DeQuizAdminController {
	
	@Autowired
	private DeQuizDBService deQuizDBService;
	
	/* Display login page for QuizMaster */
	@GetMapping("/adminlogin")
	private String showForm(@Valid Model model) {
		DeQuizLogin deQuizLogin = new DeQuizLogin();
		model.addAttribute("deQuizLogin", deQuizLogin);
		return "adminLogin";
	}
	
	/* Sign up for new Quiz Master */
	@GetMapping("/signUp")
	private String showSignUpForm(Model model) {
		DeQuizLogin deQuizLogin = new DeQuizLogin();
		model.addAttribute("deQuizLogin", deQuizLogin);
		return "adminSignUp";
	}
	
	/* Sign up for new Quiz Master */
	/* validation - check if user id exists in database */
	@PostMapping("/saveAdmin")
	public String saveAdmin(@Valid @ModelAttribute("deQuizLogin") DeQuizLogin deQuizLoginPara, BindingResult bindingResult, Model model) {
		if(deQuizLoginPara.getDqlUserId()!=null) {
			DeQuizLogin deQuizLogin = deQuizDBService.getAdmin(deQuizLoginPara.getDqlUserId());;
			if (deQuizLogin!=null && deQuizLogin.getDqlUserId().equalsIgnoreCase(deQuizLoginPara.getDqlUserId())) {
				bindingResult.addError(new FieldError("deQuizLogin", "dqlUserId", "UserId already exists please select a new userId"));
			}
		}
		if (bindingResult.hasErrors()){
			return "adminSignUp";
		} 
		else {
			model.addAttribute("deQuizLogin", deQuizLoginPara);
			model.addAttribute("dqlUserId",deQuizLoginPara.getDqlUserId());
			deQuizDBService.saveLogin(deQuizLoginPara);
			return "adminregisterok";
		}
	}
}
