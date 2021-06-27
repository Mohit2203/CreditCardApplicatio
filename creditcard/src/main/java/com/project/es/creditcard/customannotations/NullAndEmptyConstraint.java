package com.project.es.creditcard.customannotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import com.project.es.creditcard.validations.NullAndEmptyValidator;

@Documented
@Constraint(validatedBy = NullAndEmptyValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NullAndEmptyConstraint {
	String message() default "Please enter the valid value";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}