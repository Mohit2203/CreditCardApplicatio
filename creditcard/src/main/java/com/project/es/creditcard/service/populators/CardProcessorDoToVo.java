package com.project.es.creditcard.service.populators;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.project.es.creditcard.model.CreditCardDetail;
import com.project.es.creditcard.model.Response.CardDetailsResponse;

@Component
public class CardProcessorDoToVo {

	public List<CardDetailsResponse> populateDo(List<CreditCardDetail> responseList) {
		return responseList.stream().map(o -> CardDetailsResponse.builder().name(o.getName()).balance("£0")
				.cardNumber(o.getCardNumber()).limit("£"+o.getLimit()).build()).collect(Collectors.toList());

	}

}
