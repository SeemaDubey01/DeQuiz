package com.dequiz.DeQuiz;


import javax.validation.constraints.Size;

public class User {
	
	@QuizIdConstraint
	private Integer quizId;

	
	@Size(min = 1, max = 35, message = "Please enter name")
	private String fullName;

	public Integer getQuizId() {
		return quizId;
	}

	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "user {Quiz Number =" + quizId + " Name = " + fullName + "}";
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
