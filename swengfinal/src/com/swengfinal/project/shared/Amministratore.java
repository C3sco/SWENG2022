package com.swengfinal.project.shared;

import java.io.Serializable;

public class Amministratore extends Utente implements Serializable  {

	private static final long serialVersionUID = 1L; 
	
	/**
	 * Costruttore di default
	 */
	public Amministratore(){
		
	}
	
	/**
	 * Costruttore 
	 * 
	 * @param nomeUtente di tipo String
	 * @param password di tipo String
	 * @param email di tipo String
	 * @param nome di tipo String
	 * @param cognome di tipo String
	 * @param sesso di tipo String
	 * @param luogoNascita di tipo String
	 * @param dataNascita di tipo String
	 * @param luogoDomRes di tipo String 
	 
	 */
	
	//dati amministratore
	public Amministratore(String nomeUtente, String password, String email, String nome, String cognome, 
			String sesso, String dataNascita, String luogoNascita, String luogoDomRes) {
		super(nomeUtente, password, email, nome, cognome, sesso, dataNascita, luogoNascita, luogoDomRes);
	}

}