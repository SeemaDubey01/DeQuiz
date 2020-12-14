package com.dequiz.DeQuiz.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dequiz.DeQuiz.DTO.DeQuizMaster;
import com.dequiz.DeQuiz.DTO.DeQuizUser;
import com.dequiz.DeQuiz.Repo.DeQuizUserDBRepo;
import com.dequiz.DeQuiz.Websocket.WebSocketDAO;

@Controller
public class JoinController {

	@Autowired
	DeQuizUserDBRepo deQuizUserRepo;
	@Autowired
	WebSocketDAO wsMessageDAO;

	/* when participant user plan to join a quiz - no input, post to joinQuiz with quizId and userName */
	@GetMapping("/joinQuiz")
	private String showForm(@Valid Model model) {
		DeQuizUser deQuizUser = new DeQuizUser();
		model.addAttribute("deQuizUser", deQuizUser);
		return "joinForm";
	}

	/* participant enters quiz id and name. This controller validates if quiz is active, makes entry into user table *
	 * and takes participant to Quiz screen where he awaits QuizMaster to start the quiz                             */
	@PostMapping("/joinQuiz")
	public String submitForm(@Valid @ModelAttribute("deQuizUser") DeQuizUser deQuizUser, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "joinForm";
		} else {
			deQuizUser.setDquSessionId("Q:");
			deQuizUser.setDquAnswer("X");
			deQuizUser.setDquMarks(0);
			deQuizUser.setDquTotalMarks(0);
			deQuizUser.setDquQuestionNo(0);

// save the joining user in database
			deQuizUserRepo.save(deQuizUser);
			
			DeQuizMaster deQuizMaster = new DeQuizMaster ();
			deQuizMaster.setDeqmQuizId(deQuizUser.getDquQuizId());
			deQuizMaster.setDquUserName(deQuizUser.getDquUserName());
			deQuizMaster.setDquUserId(deQuizUser.getDquUserId());
			deQuizMaster.setDquUserName(deQuizUser.getDquUserName());
			
			model.addAttribute("deQuizMaster", deQuizMaster);
			return "userInQuiz";
		}
	}
}
