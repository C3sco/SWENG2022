package swengfinal;

import com.swengfinal.project.client.GreetingService;
import com.swengfinal.project.server.GreetingServiceImpl;
import org.junit.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.Assert.*;
import com.swengfinal.project.shared.Utente;
import com.swengfinal.project.shared.Amministratore;

public class test {
	
	static GreetingServiceImpl tryTest;
	
	
	@BeforeAll
	public static void ready() {
		GreetingService i = mock(GreetingService.class);
		tryTest = new GreetingServiceImpl();
		tryTest.setMock(i);
	}
	
	/*
	// Test per creazione di un utente (amministratore)
	@Test
	@DisplayName("Test creazione utente")
	public void start() {
		tryTest.tryUser();
	}*/
	
	@Test
	@DisplayName("Test login")
	public void testLogin() {
		Utente u =  new Amministratore("admi","admi","admi","admi","admi","admi");
		 
		tryTest.tryUser();
		//assertEquals(0,tryTest.login("mariobianchi@gmail.com","psw" )); //utente inesistente
		assertEquals(u,  tryTest.login("admi", "admi")); //utente esistente

	}
	
	

}
