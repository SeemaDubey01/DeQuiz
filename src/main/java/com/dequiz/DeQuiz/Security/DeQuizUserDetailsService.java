package com.dequiz.DeQuiz.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dequiz.DeQuiz.DTO.DeQuizLogin;
import com.dequiz.DeQuiz.Service.DeQuizDBService;

@Service
public class DeQuizUserDetailsService implements UserDetailsService{

	@Autowired
	DeQuizDBService deQuizDBService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loading user by username");
		DeQuizLogin deQuizLogin = deQuizDBService.getAdmin(username);
		return new DeQuizUserDetails(deQuizLogin);
	}

}
