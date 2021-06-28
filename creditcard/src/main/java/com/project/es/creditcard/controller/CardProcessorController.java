/**
 * 
 */
package com.project.es.creditcard.controller;

import java.util.List;

import javax.validation.Valid;
import com.project.es.creditcard.Exception.CardNumberLuhnValidationException;
import com.project.es.creditcard.service.populators.CardProcessorVoToDo;
import com.project.es.creditcard.validations.CardNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.es.creditcard.constant.ApplicationConstants;
import com.project.es.creditcard.model.Request.CardProcessorRequest;
import com.project.es.creditcard.model.Response.CardDetailsResponse;
import com.project.es.creditcard.model.Response.MessageResponse;
import com.project.es.creditcard.service.CardProcessingService;

/**
 * @author Mohit
 *
 */
@RestController
public class CardProcessorController {

	@Autowired
	private CardProcessingService cardProcessingService;


	@PostMapping(value = "/addCard", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<MessageResponse> addCardDetails(
			@Valid @RequestBody CardProcessorRequest request) {
		if(!CardNumberValidator.isValidCard(request.getCardNumber())) throw new CardNumberLuhnValidationException();
		cardProcessingService.addCardDetails(request);
		return new ResponseEntity<MessageResponse>(new MessageResponse(ApplicationConstants.ADD_SUCCESS),
				HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllCards", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<List<CardDetailsResponse>> getAllCards() {
		List<CardDetailsResponse> responseList = cardProcessingService.getCardsList();
		return new ResponseEntity<List<CardDetailsResponse>>(responseList, HttpStatus.OK);
	}
}
