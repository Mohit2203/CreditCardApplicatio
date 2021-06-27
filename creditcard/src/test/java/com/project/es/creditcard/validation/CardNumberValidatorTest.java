package com.project.es.creditcard.validation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.project.es.creditcard.validations.CardNumberValidator;

@RunWith(MockitoJUnitRunner.class)
public class CardNumberValidatorTest {
	
	@InjectMocks
	CardNumberValidator cardNumberValidator;
	
	@Test
	public void testStringCardNumber() {
		boolean value= cardNumberValidator.isValidCard("376684392811000");
		boolean value2= cardNumberValidator.isValidCard("376684392811003");
		Assert.assertEquals(value2,Boolean.TRUE);
		Assert.assertEquals(value,Boolean.FALSE);
		//.out.println(value +" "+ value2);
	}

	@Test
	public void testStringCardEmptyCheck(){
		boolean value= cardNumberValidator.isValid(" ",  null);
		Assert.assertEquals(value,Boolean.FALSE);
	}

	@Test
	public void testStringCardNullCheck(){
		boolean value= cardNumberValidator.isValid(null,  null);
		Assert.assertEquals(value,Boolean.FALSE);
	}
}
