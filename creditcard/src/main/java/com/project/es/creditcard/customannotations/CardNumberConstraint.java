package com.project.es.creditcard.customannotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.project.es.creditcard.validations.CardNumberValidator;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = CardNumberValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CardNumberConstraint {
	String message() default "Invalid card number";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}