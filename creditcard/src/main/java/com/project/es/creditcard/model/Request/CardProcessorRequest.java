package com.project.es.creditcard.model.Request;

import com.project.es.creditcard.customannotations.CardNumberConstraint;
import com.project.es.creditcard.customannotations.NullAndEmptyConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CardProcessorRequest {

	@NullAndEmptyConstraint
	private String name;

	@CardNumberConstraint
	private String cardNumber;

	@NullAndEmptyConstraint
	private String limit;
}
