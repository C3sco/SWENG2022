package com.swengfinal.project.shared;

import java.io.Serializable;

public class Amministratore extends Utente implements Serializable  {

	private static final long serialVersionUID = 1L; 
	private String email;
	private String password;
	private String nomeUtente;

	public Amministratore(){
		
	}

	public Amministratore(String email, String password, String nomeUtente) {
		this.email=email;
		this.password=password;
		this.nomeUtente=nomeUtente;
	}

}