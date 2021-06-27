package com.project.es.creditcard.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.project.es.creditcard.customannotations.CardNumberConstraint;

public class CardNumberValidator implements ConstraintValidator<CardNumberConstraint, String> {

	@Override
	public void initialize(CardNumberConstraint cardNumber) {
	}

	@Override
	public boolean isValid(String cardNumber, ConstraintValidatorContext cxt) {
		boolean isValid;
		//System.out.println("Enter Validator");
		if (cardNumber != null  && cardNumber.matches("[0-9]+") && (cardNumber.length() > 0 )
				&& (cardNumber.length() < 20)) {
			isValid = true;
		} else {
			//System.out.println("enter else");
			isValid = false;
		
		}
		//System.out.println("Value isValid"+isValid);
		return isValid;
	}
	public static  boolean isValidCard(String cardNumber){
		int[] cardArray = {cardNumber.length() % 2 == 0 ? 1 : 2};
		boolean isValid = cardNumber.chars()
						.map(i -> i - '0')
						.map(n -> n * (cardArray[0] = cardArray[0] == 1 ? 2 : 1))
						.map(n -> n > 9 ? n - 9 : n)
						.sum() % 10 == 0;
		return isValid;
	}

	/*public boolean isValidCard2(String cardNumber){
		int cardDigits = cardNumber.length();
		int sumOfCardDigit = 0;
		boolean isSecond = false;
		for (int i = cardDigits - 1; i >= 0; i--)
		{
			int d = cardNumber.charAt(i) - '0';
			//System.out.println(d);

			if (isSecond == true) d = d * 2;
			sumOfCardDigit += d / 10;
			sumOfCardDigit += d % 10;
			isSecond = !isSecond;
		}
		return (sumOfCardDigit % 10 == 0);*/
	}

