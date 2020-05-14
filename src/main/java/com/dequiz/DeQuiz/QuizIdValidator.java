package com.dequiz.DeQuiz;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class QuizIdValidator implements ConstraintValidator<QuizIdConstraint, Integer> {
	
	 @Override
	    public void initialize(QuizIdConstraint quizId) {
	    }
	 
	    @Override
	    public boolean isValid(Integer quizIdField,
	      ConstraintValidatorContext cxt) {
	        return quizIdField !=null && quizIdField ==101 && quizIdField.equals(101);
	    }

}
