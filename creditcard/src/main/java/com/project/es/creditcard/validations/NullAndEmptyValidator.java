package com.project.es.creditcard.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.project.es.creditcard.customannotations.NullAndEmptyConstraint;

public class NullAndEmptyValidator implements ConstraintValidator<NullAndEmptyConstraint, String> {
	
	@Override
	public void initialize(NullAndEmptyConstraint nameandlimit) {
	}

	@Override
	public boolean isValid(String valueCheck, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub &&(valueCheck.matches("^[a-zA-Z \\s]*$")
		boolean isValid;
		if (valueCheck != null && !valueCheck.trim().isEmpty())
				 {
			isValid = true;
		} else {
			isValid = false;
		
		}
		return isValid;
	}
	

}
