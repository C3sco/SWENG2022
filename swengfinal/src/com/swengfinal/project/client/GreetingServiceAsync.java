package com.swengfinal.project.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.swengfinal.project.shared.Utente;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback) throws IllegalArgumentException;
	
	
	/**
	 * Metodi dell'utente 
	 */
	void registrazione(ArrayList<String> dati, AsyncCallback<String> callback) throws IllegalArgumentException;
	
	void login(String username, String password, AsyncCallback<Utente> callback) throws IllegalArgumentException;
	
	void getInfoUtente(String email, AsyncCallback<String> callback)throws IllegalArgumentException;

	void getUtente(String email, AsyncCallback<Utente> callback)throws IllegalArgumentException;	

	/**
	 * Metodi del corso
	 */
	void creazioneCorso(ArrayList<String> dati, AsyncCallback<String> callback) throws IllegalArgumentException;


	
}
