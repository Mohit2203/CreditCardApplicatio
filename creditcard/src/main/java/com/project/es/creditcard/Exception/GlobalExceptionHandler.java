package com.project.es.creditcard.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.project.es.creditcard.constant.ApplicationConstants;
import com.project.es.creditcard.model.Response.MessageResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoDataFoundException.class)
	@ResponseBody
	public ResponseEntity<MessageResponse> processNoDataExceptionHandler() {
		return new ResponseEntity<MessageResponse>(new MessageResponse(ApplicationConstants.NO_DATA_FOUND),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ResponseEntity<MessageResponse> processMethodArgumentNotValidExceptionExceptionHandler(
			MethodArgumentNotValidException e) {
		for (FieldError err : e.getFieldErrors()) {
			if (err.getDefaultMessage().equals("Invalid card number")) {
				return new ResponseEntity<MessageResponse>(
						new MessageResponse(ApplicationConstants.INVALID_CARD_NUMBER), HttpStatus.BAD_REQUEST);
			}
		}
		return new ResponseEntity<MessageResponse>(new MessageResponse(ApplicationConstants.EMPTY_FIELDS),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CardNumberNotUniqueException.class)
	@ResponseBody
	public ResponseEntity<MessageResponse> processCardNumberNotUniqueExceptionHandler() {
		return new ResponseEntity<MessageResponse>(new MessageResponse(ApplicationConstants.CARD_NUMBER_ALREADY_EXIST),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CardNumberLuhnValidationException.class)
	@ResponseBody
	public ResponseEntity<MessageResponse> processCardNumberLuhnValidationExceptionHandler() {
		return new ResponseEntity<MessageResponse>(new MessageResponse(ApplicationConstants.CARD_LUHN_VALIDATION),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<MessageResponse> processExceptionHandler() {
		return new ResponseEntity<MessageResponse>(new MessageResponse(ApplicationConstants.INTERNAL_SERVER_ERROR),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
