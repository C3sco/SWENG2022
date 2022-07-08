package com.swengfinal.project.shared;

import java.io.Serializable;

public abstract class Utente implements Serializable { 

	private static final long serialVersionUID = 1L;

	private String email;
	private String password;
	private String nome;
	private String cognome;
	private String luogoNascita;
	private String dataNascita;
	

	public Utente()	{
	}

	public Utente(String email, String password, String nome, String cognome,
			String luogoNascita, String dataNascita) {
		this.password = password;
		this.email = email;
		this.nome = nome;
		this.cognome = cognome;
		this.luogoNascita = luogoNascita;
		this.dataNascita = dataNascita;
		
	
	}
	
	public String getEmail(){
		return this.email;		
	}

	public String getPw(){
		return this.password;
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
	
	

}