package goodwine.server.controller.test;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;  
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 
import org.springframework.boot.test.context.SpringBootTest;
import java.time.Instant;
import java.util.Date;
import goodwine.server.pojos.Utente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MvcResult;
import org.junit.jupiter.api.Assertions;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc //@WebMvcTest 
@SpringBootTest
public class UtenteControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void registrazioneUtenteSuccesso() throws Exception {
		Utente u = new Utente();
		u.setUsername("giggino");
		u.setPassword("23456789");
		
		MvcResult res = this.mockMvc.perform(post("/utente/registrazione")
							 				.contentType(MediaType.APPLICATION_JSON)
							 				.content(asJsonString(u)))
				    		.andDo(print())//stampo la risposta e controllo che lo stato di ritorno sia ok
				    		.andExpect(status().isOk())
				    		.andReturn();
					
		Assertions.assertTrue(res.getResponse().getContentAsString().contains("giggino"));
	}
	
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	
}
