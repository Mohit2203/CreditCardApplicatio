package com.project.es.creditcard.service.populators;

import org.springframework.stereotype.Component;

import com.project.es.creditcard.model.CreditCardDetail;
import com.project.es.creditcard.model.Request.CardProcessorRequest;

@Component
public class CardProcessorVoToDo {

	public CreditCardDetail populateDo(CardProcessorRequest requestObject) {
		return CreditCardDetail.builder().name(requestObject.getName()).cardNumber(requestObject.getCardNumber())
				.limit(requestObject.getLimit()).build();
	}

}
