package com.swengfinal.project.shared;

import java.io.Serializable;

/**
 * Classe per la definizione di un utente
 *
 * @author Giacomo Rondelli, Gabriele Malossi, Giacomo Pazzaglia
 */

public class Utente implements Serializable { 

	private static final long serialVersionUID = 1L;

	private String nomeUtente;
	private String password; 
	private String email;
	private String nome;
	private String cognome;
	private String sesso;
	private String luogoNascita;
	private String dataNascita;
	private String luogoDomRes;


     /**
	 * Costruttore di utente
	 */
	public Utente()	{
		
	}

	/**
	 * Costruttore 
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
	public Utente(String nomeUtente, String password, String email, String nome, String cognome, 
			String sesso,  String dataNascita, String luogoNascita, String luogoDomRes) {
		this.nomeUtente = nomeUtente;
		this.password = password;
		this.email = email;
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.dataNascita=dataNascita;
		this.luogoNascita = luogoNascita;
		this.luogoDomRes = luogoDomRes;
		
	}

	/**
	 * Estrattore nome utente
	 * @return utente di tipo String
	 */
	public String getNomeUtente(){
		return this.nomeUtente;
	}

	/**
	 * Estrattore passoword 
	 * @return passoword di tipo String
	 */
	public String getPw(){
		return this.password;		
	}

	/**
	 * Estrattore email 
	 * @return email di tipo String
	 */
	public String getEmail(){
		return this.email;		
	}

	/**
	 * Estrattore nome
	 * @return nome di tipo String
	 */
	public String getNome(){
		return this.nome;		
	}

	/**	
	 * Estrattore cognome
	 * @return cognome di tipo String
	 */
	public String getCognome(){
		return this.cognome;		
	}

	/**
	 * Estrattore sesso
	 * @return sesso di tipo String
	 */
	public String getSesso(){
		return this.sesso;		
	}

	/**
	 * Estrattore luogo di nascita
	 * @return luogoNascita di tipo String
	 */
	public String getLuogoNascita(){
		return this.luogoNascita;		
	}

	/**
	 * Estrattore data di nascita
	 * @return dataNascita di tipo String
	 */
	public String getDataNascita(){
		return this.dataNascita;		
	}

	/**
	 * Estrattore luogo domicilio/residenza
	 * @return luogoDomRes di tipo String
	 */
	public String getLuogo(){
		return this.luogoDomRes;		
	}

	
}