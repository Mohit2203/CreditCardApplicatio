package com.project.es.creditcard.ServiceTest;

import com.project.es.creditcard.Exception.NoDataFoundException;
import com.project.es.creditcard.model.CreditCardDetail;
import com.project.es.creditcard.model.Request.CardProcessorRequest;
import com.project.es.creditcard.model.Response.CardDetailsResponse;
import com.project.es.creditcard.repository.CardProcessingRepository;
import com.project.es.creditcard.service.CardProcessingServiceImpl;
import com.project.es.creditcard.service.populators.CardProcessorDoToVo;
import com.project.es.creditcard.service.populators.CardProcessorVoToDo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CardProcessingServiceImplTest {

	@Spy
	private CardProcessorDoToVo cardProcessorDoToVo;

	@Mock
	private CardProcessingRepository cardProcessingRepository;

	@Mock
	private CardProcessorVoToDo cardProcessorVoToDo;

	@Mock
	private CreditCardDetail creditCardDetail;

	@InjectMocks
	private CardProcessingServiceImpl cardProcessingServiceImpl;

	

	@Test
	public void testGetCardsList() {
		when(cardProcessingRepository.findAll()).thenReturn(getCreditCardDetails());
		List<CardDetailsResponse> cardDetailsResponse =cardProcessingServiceImpl.getCardsList();
		Assert.assertEquals(cardDetailsResponse.size(),4);

	}

	@Test
	public void testAddCardDetails() {
		CardProcessorRequest request = new CardProcessorRequest();
		when(cardProcessorVoToDo.populateDo(any())).thenReturn(creditCardDetail);
		cardProcessingServiceImpl.addCardDetails(request);
		verify(cardProcessingRepository).save(creditCardDetail);
	}
	
	@Test(expected = NoDataFoundException.class)
	public void testNoDataFoundException() {
		when(cardProcessingRepository.findAll()).thenReturn(null);
		List<CardDetailsResponse> cardDetailsResponse =cardProcessingServiceImpl.getCardsList();
	}

	public List<CreditCardDetail> getCreditCardDetails() {
		CreditCardDetail creditCardDetail = new CreditCardDetail(1l, "Bob", "1234567890", "£1000", "£0");
		CreditCardDetail creditCardDetail1 = new CreditCardDetail(1l, "Bill", "1234567890", "£1000", "£0");
		CreditCardDetail creditCardDetail2 = new CreditCardDetail(1l, "Mohit", "234567890", "£1000", "£0");
		CreditCardDetail creditCardDetail3 = new CreditCardDetail(1l, "Gaurav", "1282828", "£30000", "£0");
		List<CreditCardDetail> creditCard = new ArrayList<CreditCardDetail>();
		creditCard.add(creditCardDetail);
		creditCard.add(creditCardDetail1);
		creditCard.add(creditCardDetail2);
		creditCard.add(creditCardDetail3);

		return creditCard;

	}
}
