package com.project.es.creditcard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.es.creditcard.Exception.CardNumberNotUniqueException;
import com.project.es.creditcard.Exception.NoDataFoundException;
import com.project.es.creditcard.model.CreditCardDetail;
import com.project.es.creditcard.model.Request.CardProcessorRequest;
import com.project.es.creditcard.model.Response.CardDetailsResponse;
import com.project.es.creditcard.repository.CardProcessingRepository;
import com.project.es.creditcard.service.populators.CardProcessorDoToVo;
import com.project.es.creditcard.service.populators.CardProcessorVoToDo;

@Service
public class CardProcessingServiceImpl implements CardProcessingService {

	@Autowired
	private CardProcessingRepository cardProcessingRepository;
	@Autowired
	private CardProcessorVoToDo cardProcessorVoToDo;
	@Autowired
	private CardProcessorDoToVo cardProcessorDoToVo;

	@Override
	public void addCardDetails(CardProcessorRequest requestObject) {
		if (null == cardProcessingRepository.findByCardNumber(requestObject.getCardNumber()))
			cardProcessingRepository.save(cardProcessorVoToDo.populateDo(requestObject));
		else
			throw new CardNumberNotUniqueException();
	}

	@Override
	public List<CardDetailsResponse> getCardsList() {
		List<CreditCardDetail> response = cardProcessingRepository.findAll();
		if (null == response || response.isEmpty())
			throw new NoDataFoundException();
		return cardProcessorDoToVo.populateDo(response);
	}

}
