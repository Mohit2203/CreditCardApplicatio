package com.project.es.creditcard.ControllerTest;

import com.project.es.creditcard.controller.CardProcessorController;
import com.project.es.creditcard.service.CardProcessingService;
import com.project.es.creditcard.service.populators.CardProcessorVoToDo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CardProcessorControllerTest{

    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    CardProcessorController cardProcessorController;

    @Mock
    private CardProcessingService cardProcessingService;

    @Mock
    private CardProcessorVoToDo cardProcessorVoToDo;

    @Before
    public void initialize(){
        //MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(CardProcessorController.class).build();
    }

    @Test
    public void testStandardRequest() throws Exception {
        when(cardProcessingService.getCardsList()).thenReturn(new ArrayList<>());
        mockMvc.perform(MockMvcRequestBuilders.get("/getAllCards")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
}
