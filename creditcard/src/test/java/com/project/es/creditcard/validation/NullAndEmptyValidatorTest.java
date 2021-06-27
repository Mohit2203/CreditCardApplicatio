package com.project.es.creditcard.validation;

import com.project.es.creditcard.validations.NullAndEmptyValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NullAndEmptyValidatorTest {

    @InjectMocks
    NullAndEmptyValidator nullAndEmptyValidator;

    @Test
    public void testNullandEmptyValue(){

        boolean value= nullAndEmptyValidator.isValid("",null);
        Assert.assertEquals(value,Boolean.FALSE);

    }
}
