package com.project.es.creditcard.service;

import java.util.List;

import com.project.es.creditcard.model.Request.CardProcessorRequest;
import com.project.es.creditcard.model.Response.CardDetailsResponse;

public interface CardProcessingService {

	public void addCardDetails(CardProcessorRequest requestObjec);

	public List<CardDetailsResponse> getCardsList();
}
