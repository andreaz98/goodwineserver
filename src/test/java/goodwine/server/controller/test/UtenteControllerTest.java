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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 
import org.springframework.boot.test.context.SpringBootTest;
import java.time.Instant;
import java.util.Date;
import goodwine.server.pojos.Utente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MvcResult;
import org.junit.jupiter.api.Assertions;
import goodwine.server.persistenza.UtenteRepository;

//@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc //@WebMvcTest 
@SpringBootTest
public class UtenteControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private UtenteRepository utenteRepo;
	
	@Test
	public void registrazioneUtenteSuccesso() throws Exception {
		Utente u = new Utente();
		u.setUsername("giggino");
		u.setPassword("23456789");
		
		MvcResult res = this.mockMvc.perform(post("/utente/registrazione")
							 				.contentType(MediaType.APPLICATION_JSON)
							 				.content(asJsonString(u)))
				    		.andDo(print())
				    		.andExpect(status().isOk())
				    		.andReturn();
					
		Assertions.assertTrue(res.getResponse().getContentAsString().contains("giggino"));
	}
	
	@Test
	public void loginSuccesso() throws Exception {
		Utente u = new Utente();
		u.setUsername("giggino");
		u.setPassword("23456789");
		
		utenteRepo.save(u);
		
		MvcResult res = this.mockMvc.perform(post("/utente/login").contentType(MediaType.APPLICATION_JSON)
							 .content(asJsonString(u)))
				    .andDo(print())
				    .andExpect(status().isOk())
				    .andReturn();
		
		Assertions.assertTrue(res.getResponse().getContentAsString().contains("true"));
	}
	
	@Test
	public void loginFallimento()throws Exception {
		Utente u = new Utente();
		u.setUsername("utenteInesistentegiggino");
		u.setPassword("23456789");
		
		MvcResult res =  this.mockMvc.perform(post("/utente/login")
							 .contentType(MediaType.APPLICATION_JSON)
							 .content(asJsonString(u)))
				    	 .andDo(print())
				    	 .andExpect(status().isOk())
				    	 .andReturn();
		
		Assertions.assertTrue(res.getResponse().getContentAsString().contains("false"));
	}
	
	
	
	
	
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	
}
