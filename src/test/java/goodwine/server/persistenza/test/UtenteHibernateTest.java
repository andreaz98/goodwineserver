package goodwine.server.persistenza.test;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
import org.springframework.boot.test.context.SpringBootTest;

import goodwine.server.persistenza.UtenteRepository;
import goodwine.server.pojos.Utente;

import java.util.NoSuchElementException;

@RunWith(SpringJUnit4ClassRunner.class) @SpringBootTest
public class UtenteHibernateTest {
	@Autowired  
    private UtenteRepository employeeRepo; 
	
	@Test  
    public void testRegistrazioneUtente()  
    {  
     Utente emp = new Utente();  
     emp.setUsername("marcoCarola");
     emp.setPassword("987654321");
     
     employeeRepo.save(emp);  //registrazione
     
     Assertions.assertEquals("marcoCarola",employeeRepo.findById("marcoCarola").get().getUsername());
    }  
	
	@Test  
    public void testFindById() {  
		Utente emp = new Utente();  
	    emp.setUsername("ioSonoUnNuovoUtente");
	    emp.setPassword("987654321");
	    employeeRepo.save(emp);
		Utente emp2 = employeeRepo.findById("ioSonoUnNuovoUtente").get();  
		Assertions.assertEquals("ioSonoUnNuovoUtente",emp2.getUsername());
    }
	
	@Test(expected = NoSuchElementException.class)
    public void testUtenteInesistente()  
    {    
     employeeRepo.findById("ioNonEsisto!!").get();
    } 
}
