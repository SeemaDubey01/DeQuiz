package com.dequiz.DeQuiz.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class DeQuizMaster {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer deqmSrNbr;
	private Integer deqmQuizId;
	private Integer deqmQuestionNo;
	private String deqmQuestion;
	private String deqmOption_a;
	private String deqmOption_b;
	private String deqmOption_c;
	private String deqmOption_d; 
	private String deqmAnswer;
	private String deqmQuizActive;
	
	@Transient
	private String selectedAnswer;
	@Transient
	private Integer dquUserId;

/*
    @OneToMany(targetEntity=DeQuizUser.class,cascade=CascadeType.ALL )
    @JoinColumn(referencedColumnName="dquUserId")
    private List<DeQuizUser> users = new ArrayList<DeQuizUser>();
 */   
	public Integer getDquUserId() {
		return dquUserId;
	}
	public void setDquUserId(Integer dquUserId) {
		this.dquUserId = dquUserId;
	}
	public String getSelectedAnswer() {
		return selectedAnswer;
	}
	public void setSelectedAnswer(String selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}
	public Integer getDeqmQuizId() {
		return deqmQuizId;
	}
	public void setDeqmQuizId(Integer deqmQuizId) {
		this.deqmQuizId = deqmQuizId;
	}
	public Integer getDeqmQuestionNo() {
		return deqmQuestionNo;
	}
	public void setDeqmQuestionNo(Integer deqmQuestionNo) {
		this.deqmQuestionNo = deqmQuestionNo;
	}
	public String getDeqmQuestion() {
		return deqmQuestion;
	}
	public void setDeqmQuestion(String deqmQuestion) {
		this.deqmQuestion = deqmQuestion;
	} 
	public String getDeqmOption_a() {
		return deqmOption_a;
	}
	public void setDeqmOption_a(String deqmOption_a) {
		this.deqmOption_a = deqmOption_a;
	}
	public String getDeqmOption_b() {
		return deqmOption_b;
	}
	public void setDeqmOption_b(String deqmOption_b) {
		this.deqmOption_b = deqmOption_b;
	}
	public String getDeqmOption_c() {
		return deqmOption_c;
	}
	public void setDeqmOption_c(String deqmOption_c) {
		this.deqmOption_c = deqmOption_c;
	}
	public String getDeqmOption_d() {
		return deqmOption_d;
	}
	public void setDeqmOption_d(String deqmOption_d) {
		this.deqmOption_d = deqmOption_d;
	}
	public String getDeqmAnswer() {
		return deqmAnswer;
	}
	public void setDeqmAnswer(String deqmAnswer) {
		this.deqmAnswer = deqmAnswer;
	}
	public Integer getDeqmSrNbr() {
		return deqmSrNbr;
	}
	public void setDeqmSrNbr(Integer deqmSrNbr) {
		this.deqmSrNbr = deqmSrNbr;
	}
	public String getDeqmQuizActive() {
		return deqmQuizActive;
	}
	public void setDeqmQuizActive(String deqmQuizActive) {
		this.deqmQuizActive = deqmQuizActive;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "quidId: " + deqmQuizId + " question#: " + deqmQuestionNo + 
				" question: " + deqmQuestion + 
				" a: " + deqmOption_a + " b: " + deqmOption_b + " c: " + deqmOption_c
				+ " d: " + deqmOption_d + " ans: " + deqmAnswer ;
	}
	
}

