package goodwine.server.persistenza.test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;  

import goodwine.server.persistenza.BottigliaRepository;
import goodwine.server.pojos.Bottiglia;

@RunWith(SpringJUnit4ClassRunner.class) @SpringBootTest
public class BottigliaTest {
	@Autowired
	BottigliaRepository bottigliaRepo;
	
	@Test
	public void inserimentiMultipliBottiglia() {
		Bottiglia b = new Bottiglia();
		b.setLuogo("Morciano");
		b.setNome("vino bello");
		b.setNomeCantina("cantina bella");
		
		bottigliaRepo.save(b);
		Assertions.assertTrue(bottigliaRepo.findById(1L).get().getLuogo().equals("Morciano"));
		
		Bottiglia c = new Bottiglia();
		c.setLuogo("Isola");
		c.setNome("vino  non bello");
		c.setNomeCantina("cantina non bella");
		
		bottigliaRepo.save(c);
		Assertions.assertTrue(bottigliaRepo.findById(2L).get().getLuogo().equals("Isola"));
	}
	
	
}
