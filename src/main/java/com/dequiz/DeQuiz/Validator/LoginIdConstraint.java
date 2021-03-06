package com.dequiz.DeQuiz.Validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = LoginValidator.class)
@Target( { ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

public @interface LoginIdConstraint {
	String message() default"Userid/Password in not correct";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String field();

    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
    	LoginIdConstraint[] value();

}
}
