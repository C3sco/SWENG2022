package com.swengfinal.project.shared;

import java.io.Serializable;

public class Utente implements Serializable { 

	private static final long serialVersionUID = 1L;

	private String email;
	private String password;
	private String nomeUtente;
	private String matricola;
	private String nome;
	private String cognome;
	private String luogoNascita;
	private String dataNascita;
	private String tipologia;

	public Utente()	{
	}

	public Utente(String email, String password, String nomeUtente, String matricola, String nome, String cognome,
			String luogoNascita, String dataNascita, String tipologia) {
		this.nomeUtente = nomeUtente;
		this.password = password;
		this.email = email;
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.luogoNascita = luogoNascita;
		this.dataNascita = dataNascita;
		this.tipologia = tipologia; 
	
	}
	
	public String getEmail(){
		return this.email;		
	}

	public String getPw(){
		return this.password;
	}
	
	public String getNomeUtente(){
		return this.nomeUtente;
	}
	
	public String getMatricola() {
		return this.matricola;
	}

	public String getNome(){
		return this.nome;		
	}

	public String getCognome(){
		return this.cognome;		
	}

	public String getLuogoNascita(){
		return this.luogoNascita;		
	}

	public String getDataNascita(){
		return this.dataNascita;		
	}
	
	public String getTipologia() {
		return this.tipologia;
	}

}