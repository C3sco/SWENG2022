package swengfinal;

import com.swengfinal.project.client.GreetingService;
import com.swengfinal.project.server.GreetingServiceImpl;
import org.junit.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.Assert.*;
import com.swengfinal.project.shared.Utente;
import com.swengfinal.project.shared.Amministratore;
import com.swengfinal.project.shared.Studente;

public class test {
	
	static GreetingServiceImpl tryTest;
	
	
	@BeforeAll
	public static void ready() {
		GreetingService i = mock(GreetingService.class);
		tryTest = new GreetingServiceImpl();
		tryTest.setMock(i);
	}
	
	
	// Test per creazione di un utente (amministratore)
	@Test
	@DisplayName("Test creazione utente")
	public void start() {
		tryTest.tryUser();
	}
	
	@Test
	@DisplayName("Test registrazione studente")
	public void testRegistrazione() {
		ArrayList<String> info = new ArrayList<String>();
		info.add("email123");
		info.add("password");
		info.add("Nome");
		info.add("Cognome");
		info.add("Luogo Nascita");
		info.add("Data Nascita");
		info.add("Matricola");
		tryTest.deleteUtente(info.get(0));
		assertEquals("Registrazione completata", tryTest.registrazioneStudente(info));
		
	}
	
	@Test
	@DisplayName("Test login")
	public void testLogin() {
		Studente u = new Studente("email123","password","Nome","Cognome",
				"Luogo Nascita","Data Nascita","Matricola");
		Utente k = tryTest.login("email123", "password");

		//assertEquals(0,tryTest.login("mariobianchi@gmail.com","psw" )); //utente inesistente
		
		//utente esistente, controllo la mail che è univoca nel db
		assertEquals(u.getEmail(), tryTest.login("email123", "password").getEmail());

	}
	

	
	

}
