package com.dequiz.DeQuiz.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import com.dequiz.DeQuiz.validator.QuizIdConstraint;
import com.sun.istack.NotNull;


@Entity
public class DeQuizUser {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer dquUserId;
	@NotNull()
	@QuizIdConstraint
	private Integer dquQuizId;
	@Size(min = 3, max = 35, message = "Please enter name")
	private String dquUserName;
	private String dquSessionId;
	private Integer dquMarks;
	private String dquAnswer;
	private Integer dquTotalMarks;
    
	@Transient
	private Integer dquQuestionNo;
	
	public Integer getDquQuestionNo() {
		return dquQuestionNo;
	}

	public void setDquQuestionNo(Integer dquQuestionNo) {
		this.dquQuestionNo = dquQuestionNo;
	}

	public DeQuizUser() {
	}

	public String getDquAnswer() {
		return dquAnswer;
	}

	public void setDquAnswer(String dquAnswer) {
		this.dquAnswer = dquAnswer;
	}

	public Integer getDquTotalMarks() {
		return dquTotalMarks;
	}

	public void setDquTotalMarks(Integer dquTotalMarks) {
		this.dquTotalMarks = dquTotalMarks;
	}

	public Integer getDquUserId() {
		return dquUserId;
	}

	public void setDquUserId(Integer dquUserId) {
		this.dquUserId = dquUserId;
	}

	public Integer getDquQuizId() {
		return dquQuizId;
	}

	public void setDquQuizId(Integer dquQuizId) {
		this.dquQuizId = dquQuizId;
	}

	public String getDquUserName() {
		return dquUserName;
	}

	public void setDquUserName(String dquUserName) {
		this.dquUserName = dquUserName;
	}

	public String getDquSessionId() {
		return dquSessionId;
	}

	public void setDquSessionId(String dquSessionId) {
		this.dquSessionId = dquSessionId;
	}

	public Integer getDquMarks() {
		return dquMarks;
	}

	public void setDquMarks(Integer dquMarks) {
		this.dquMarks = dquMarks;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "userId = " + dquUserId + "quizId: " + dquQuizId + " userName: " + dquUserName + " session id: " + dquSessionId + " marks: " + dquMarks ;
	}
	
		
}