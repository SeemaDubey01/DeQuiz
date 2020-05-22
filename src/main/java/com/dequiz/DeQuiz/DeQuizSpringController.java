package com.dequiz.DeQuiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String submitForm(@Valid @ModelAttribute("user") DeQuizUser user, BindingResult bindingResult,
			HttpSession session, Model model) {
		String usersession = session.getId();
		if (bindingResult.hasErrors()) {
			return "register_form";
		} else {
			user.setDquSessionId(usersession);
			user.setDquAnswer("");
			user.setDquMarks(0);
			user.setDquTotalMarks(0);
			model.addAttribute("user", user);
			userRepo.save(user);
			return "register_success";

		}
	}

	@GetMapping("/startQuiz")
	private String showQuiz(@ModelAttribute("user") DeQuizUser user, Model model,
			@RequestParam(defaultValue = "test") Integer dquUserId) {
		List<DeQuizMaster> qlist = new ArrayList<DeQuizMaster>();
		qlist = dequizMasterrepo.findAll();

		DeQuizMaster dquizMaster = qlist.get(1);
		dquizMaster.setDquUserId(dquUserId);
		model.addAttribute("dquizMaster", dquizMaster);
		return "start_quiz";
	}

	@Autowired
	DeQuizMasterDBRepo dequizMasterrepo;

	@PostMapping("/getResult")
	private String showResult(@ModelAttribute("dquizMaster") DeQuizMaster dquizMaster, Model model) {
		List<DeQuizMaster> qlist = new ArrayList<DeQuizMaster>();
		qlist = dequizMasterrepo.findAll();
		DeQuizMaster dquizMasterDB = qlist.get(1);
		Integer userId = dquizMaster.getDquUserId();
		DeQuizUser myUser = null;
		userRepo.findById(userId);
		Optional<DeQuizUser> optionalUser = userRepo.findById(userId);
		if (optionalUser.isPresent()) {
			myUser = optionalUser.get(); 
		}
		if (dquizMaster.getSelectedAnswer().equalsIgnoreCase(dquizMasterDB.getDeqmAnswer())) {
			if (myUser != null) {
				myUser.setDquAnswer(dquizMaster.getSelectedAnswer());
				myUser.setDquMarks(10);
				myUser.setDquTotalMarks(10);
				userRepo.updateUser(myUser.getDquMarks(), myUser.getDquAnswer(), myUser.getDquTotalMarks(),
						myUser.getDquUserId());
			}

			return "quiz_result_pass";
		} else {
			return "quiz_result_fail";
		}
	}

}
