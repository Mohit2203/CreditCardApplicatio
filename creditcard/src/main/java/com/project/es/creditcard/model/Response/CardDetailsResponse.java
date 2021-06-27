package com.project.es.creditcard.model.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CardDetailsResponse {

	private String name;
	private String cardNumber;
	private String  limit;
	private String  balance;

}
