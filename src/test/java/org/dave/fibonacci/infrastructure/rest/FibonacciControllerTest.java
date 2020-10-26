package org.dave.fibonacci.infrastructure.rest;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.dave.fibonacci.application.FibonacciService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(FibonacciController.class)
public class FibonacciControllerTest {
	
    @Autowired
    private MockMvc mvc;
    
    @MockBean
	FibonacciService mockService;

	@Test
	public void testGetValueFor() throws Exception {
		when(mockService.getValueFor(anyInt())).thenReturn(123L);

		mvc.perform(get("/rest/fibonacci").param("number", "123"))
		.andExpect(status().isOk())
		.andExpect(content().json("123"))
		.andReturn();
		
		//ensure the behavior is actually working as well
		Mockito.verify(mockService, atLeastOnce()).getValueFor(anyInt());
	}

}
