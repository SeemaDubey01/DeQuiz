package com.dequiz.DeQuiz;



import javax.validation.constraints.Size;

public class UserDetail {

	@QuizIdConstraint
	private Integer quizId;

	
	@Size(min = 1, max = 35, message = "Please enter name")
	private String userName;

	public Integer getQuizId() {
		return quizId;
	}

	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "user {Quiz Number =" + quizId + " Name = " + userName + "}";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
}
