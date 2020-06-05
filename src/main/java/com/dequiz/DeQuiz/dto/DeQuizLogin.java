package com.dequiz.DeQuiz.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.dequiz.DeQuiz.validator.LoginIdConstraint;

@Entity

@LoginIdConstraint.List({ @LoginIdConstraint(field = "dqlUserId", message = "Userid/password is not valid") })
public class DeQuizLogin {
	@Id
	private String dqlUserId;
	private String dqlPassword;
	private String dqlFirstName;
	private String dqlLastName;
	private String dqlEmail;
	
	

	public String getDqlUserId() {
		return dqlUserId;
	}
	public void setDqlUserId(String dqlUserId) {
		this.dqlUserId = dqlUserId;
	}
	public String getDqlFirstName() {
		return dqlFirstName;
	}
	
	public void setDqlFirstName(String dqlFirstName) {
		this.dqlFirstName = dqlFirstName;
	}
	public String getDqlPassword() {
		return dqlPassword;
	}
	public void setDqlPassword(String dqlPassword) {
		this.dqlPassword = dqlPassword;
	}
	public String getDqlLastName() {
		return dqlLastName;
	}
	public void setDqlLastName(String dqlLastName) {
		this.dqlLastName = dqlLastName;
	}
	public String getDqlEmail() {
		return dqlEmail;
	}
	public void setDqlEmail(String dqlEmail) {
		this.dqlEmail = dqlEmail;
	}
	
	
}
