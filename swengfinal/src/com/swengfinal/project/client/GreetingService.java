package com.swengfinal.project.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	String greetServer(String name) throws IllegalArgumentException;
	
	/**
	 * Metodi utente
	 */
	String registrazione(ArrayList<String> dati) throws IllegalArgumentException;
	int login(String username, String password) throws IllegalArgumentException;
	
	
	/**
	 * Metodi corso
	 */
	String creazioneCorso(ArrayList<String> dati) throws IllegalArgumentException;
	
}


