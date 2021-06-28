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
		if (cardNumber != null  && cardNumber.matches("[0-9]+") && (cardNumber.length() > 0 )
				&& (cardNumber.length() < 20)) {
			return true;
		}
		return false;
	}
	public static  boolean isValidCard(String cardNumber){
		int[] cardArray = {cardNumber.length() % 2 == 0 ? 1 : 2};
				return cardNumber.chars()
						.map(i -> i - '0')
						.map(n -> n * (cardArray[0] = cardArray[0] == 1 ? 2 : 1))
						.map(n -> n > 9 ? n - 9 : n)
						.sum() % 10 == 0;
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

