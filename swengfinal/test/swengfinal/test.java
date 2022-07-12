package swengfinal;

import com.swengfinal.project.client.GreetingService;
import com.swengfinal.project.server.GreetingServiceImpl;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.Assert.*;
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
	public void testRegistrazioneStudente() {
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
	@DisplayName("Test login studente")
	public void testLogin() {
		Studente u = new Studente("email123","password","Nome","Cognome",
				"Luogo Nascita","Data Nascita","Matricola");
		assertEquals(u.getEmail(), tryTest.login("email123", "password").getEmail());

	}
	
	@Test
	@DisplayName("Test registrazione docente")
	public void testRegistrazioneDocente() {
		ArrayList<String> info = new ArrayList<String>();
		info.add("emailDocente");
		info.add("password");
		info.add("Nome");
		info.add("Cognome");
		info.add("Luogo Nascita");
		info.add("Data Nascita");
		
		assertEquals("Registrazione completata", tryTest.registrazioneDocente(info));
		tryTest.deleteUtente(info.get(0));
	}
	
	@Test
	@DisplayName("Test registrazione amministratore")
	public void testRegistrazioneAmmministrazione() {
		ArrayList<String> info = new ArrayList<String>();
		info.add("emailAdmin");
		info.add("password");
		info.add("Nome");
		info.add("Cognome");
		info.add("Luogo Nascita");
		info.add("Data Nascita");
		
		assertEquals("Registrazione completata", tryTest.registrazioneAdmin(info));
		tryTest.deleteUtente(info.get(0));
	}
	
	@Test
	@DisplayName("Test registrazione segreteria")
	public void testRegistrazioneSegweteria() {
		ArrayList<String> info = new ArrayList<String>();
		info.add("emailSegreteria");
		info.add("password");
		info.add("Nome");
		info.add("Cognome");
		info.add("Luogo Nascita");
		info.add("Data Nascita");
		assertEquals("Registrazione completata", tryTest.registrazioneSegreteria(info));
		tryTest.deleteUtente(info.get(0));
	}
	
	@Test
	@DisplayName("Test creazione corso")
	public void testCreazioneCorso() {
		
		ArrayList<String> corso = new ArrayList<String>();
		corso.add(0,"");
		corso.add(1,"mailDocente");
		corso.add(2,"nomeCorso");
		corso.add(3,"descrizioneCorso");
		corso.add(4,"dataInizioCorso");
		corso.add(5,"dataFineCorso");
		corso.add(6,"coDocente");
		
		assertEquals("Successo",tryTest.creazioneCorso(corso));
		tryTest.deleteCorso(corso.get(2));
		

	}
	
	@Test
	@DisplayName("Test modifica corso")
	public void testModificaCorso() {
		ArrayList<String> corso = new ArrayList<String>();
		corso.add(0,"");
		corso.add(1,"mailDocente");
		corso.add(2,"nomeCorso");
		corso.add(3,"descrizioneCorso");
		corso.add(4,"dataInizioCorso");
		corso.add(5,"dataFineCorso");
		corso.add(6,"coDocente");
		tryTest.creazioneCorso(corso);
		
		corso.set(3, "nuovaDescrizione");
		
		assertEquals("Successo",tryTest.updateCorso(corso, corso.get(3)));
		
		tryTest.deleteCorso(corso.get(2));
	}
	
	
	/*
	@Test
	@DisplayName("Test iscrizione corso")
	public void testIscrizioneCorso() {
		
		
		
		assertEquals("Successo",tryTest.iscrizioneCorso(0, info.get(1)));
		
		
	}*/
	
	@Test
	@DisplayName("Test creazione esame")
	public void testCreazioneEsame() {
		

		int idCorso = 1;
		ArrayList<String> esame = new ArrayList<String>();
		esame.add(0,"");
		esame.add(1,"");
		esame.add(2,"data");
		esame.add(3,"ora");
		esame.add(4,"aula");
		esame.add(5,"cfu");
		esame.add(6,"nomeEsame");
		esame.add(7,"emailDocente");
		
		tryTest.deleteEsame(idCorso);
		assertEquals("Successo",tryTest.creazioneEsame(esame,idCorso));
		
		tryTest.deleteEsame(idCorso);
		
		
	}
	
	@Test
	@DisplayName("Test modifica esame")
	public void testModificaEsame() {
		int idCorso = 1;
		ArrayList<String> esame = new ArrayList<String>();
		esame.add(0,"");
		esame.add(1,"");
		esame.add(2,"data");
		esame.add(3,"ora");
		esame.add(4,"aula");
		esame.add(5,"cfu");
		esame.add(6,"nomeEsame");
		esame.add(7,"emailDocente");
		assertEquals("Successo",tryTest.creazioneEsame(esame,idCorso));
		
		esame.set(2, "nuovaData");
		
		assertEquals("Successo",tryTest.updateEsame(esame, idCorso));
		
		tryTest.deleteEsame(idCorso);
	}
	
	@Test
	@DisplayName("Test iscrizione esame")
	public void testIscrizioneEsame() {
	}
	
	@Test
	@DisplayName("Test invio voto")
	public void testInvioVoto() {
	}
	
	@Test
	@DisplayName("Test pubblica voto")
	public void testPubblicaVoto() {
	}
}

	
	

