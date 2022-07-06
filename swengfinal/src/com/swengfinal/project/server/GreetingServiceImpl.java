package com.swengfinal.project.server;

import com.swengfinal.project.client.GreetingService;
import com.swengfinal.project.shared.FieldVerifier;
import com.swengfinal.project.shared.Utente;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.mapdb.Serializer;

import java.io.File;
import java.util.ArrayList;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

	@Override
	public String registrazione(ArrayList<String> dati) throws IllegalArgumentException {
		return dbUtenti.registrazione(dati);
	}
	
	@Override
	public Utente login(String username, String password) {
		return dbUtenti.login(username, password);
	}

	@Override
	public String getInfoUtente(String email) throws IllegalArgumentException{
		return dbUtenti.getInfoUtente(email);
	}

	@Override
	public Utente getUtente(String email) {
		return dbUtenti.getUtente(email);
	}
	
	
	// metodi corso
	
	@Override
	public String creazioneCorso(ArrayList<String> dati) throws IllegalArgumentException {
		return dbCorso.creazioneCorso(dati);
	}
	@Override
	public String updateCorso(ArrayList<String> corsoUpdate, String nomeCorso) throws IllegalArgumentException {
		return dbCorso.modificaCorso(corsoUpdate, nomeCorso);
	}
	
	@Override
	public String iscrizioneCorso(String email, int idCorso) throws IllegalArgumentException {
		return dbCorso.iscrizioneCorso(email, idCorso);
	}
	
	@Override
	public ArrayList<String> getCorsoStudente(String email) throws IllegalArgumentException {
		return dbCorso.getCorsoStudente(email);
	}
}
