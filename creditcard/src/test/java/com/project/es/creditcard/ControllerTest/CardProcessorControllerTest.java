/*
 * package com.project.es.creditcard.ControllerTest;
 * 
 * import static org.junit.Assert.assertEquals;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.mockito.Mockito; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.http.HttpHeaders; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.MediaType; import
 * org.springframework.mock.web.MockHttpServletResponse; import
 * org.springframework.security.test.context.support.WithMockUser; import
 * org.springframework.test.context.junit4.SpringRunner; import
 * org.springframework.test.web.servlet.MockMvc; import
 * org.springframework.test.web.servlet.MvcResult; import
 * org.springframework.test.web.servlet.RequestBuilder; import
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders; import
 * com.project.es.creditcard.controller.CardProcessorController; import
 * com.project.es.creditcard.model.Request.CardProcessorRequest; import
 * com.project.es.creditcard.service.CardProcessingService;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @WebMvcTest(value = CardProcessorController.class)
 * 
 * @WithMockUser public class CardProcessorControllerTest {
 * 
 * 
 * @Autowired private MockMvc mockMvc;
 * 
 * @MockBean private CardProcessingService cardProcessingService;
 * 
 * CardProcessorRequest cardProcessorRequest = new
 * CardProcessorRequest("Mohit","9223372036854775809","20000l");
 * 
 * String exampleCardDetails =
 * "{\"name\":\"Mohit\",\"cardNumber\":\"9223372036854775809\",\"limit\":20000l}";
 * 
 * @Test public void createStudentCourse() throws Exception {
 * 
 * // studentService.addCourse to respond back with mockCourse Mockito.when(
 * cardProcessingService.addCardDetails(
 * Mockito.any(CardProcessorRequest.class)));
 * 
 * // Send course as body to /students/Student1/courses RequestBuilder
 * requestBuilder = MockMvcRequestBuilders .post("/addCard")
 * .accept(MediaType.APPLICATION_JSON).content(exampleCardDetails)
 * .contentType(MediaType.APPLICATION_JSON);
 * 
 * MvcResult result = mockMvc.perform(requestBuilder).andReturn();
 * 
 * MockHttpServletResponse response = result.getResponse();
 * 
 * assertEquals(HttpStatus.CREATED.value(), response.getStatus());
 * 
 * assertEquals("http://localhost/addCard",
 * response.getHeader(HttpHeaders.LOCATION));
 * 
 * 
 * }
 * 
 * }
 * 
 * 
 */