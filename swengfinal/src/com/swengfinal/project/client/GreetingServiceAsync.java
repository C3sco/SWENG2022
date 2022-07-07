package com.swengfinal.project.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.swengfinal.project.shared.Corso;
import com.swengfinal.project.shared.Utente;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	
	
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
	
	void updateCorso(ArrayList<String> datiCorso,String nomeCorso, AsyncCallback<String> callback)throws IllegalArgumentException;
	
	void iscrizioneCorso(String email, int idCorso, AsyncCallback<String>callback) throws IllegalArgumentException;
	
	void getAllCorso(String email, AsyncCallback<ArrayList<Corso>>callback) throws IllegalArgumentException;

	void getCorsoStudente(String email, AsyncCallback<ArrayList<String>> callback) throws IllegalArgumentException;
	
	void  getCorsi(AsyncCallback<ArrayList<Corso>> callback) throws IllegalArgumentException;
	
}
