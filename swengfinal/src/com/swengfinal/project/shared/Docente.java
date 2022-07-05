package com.swengfinal.project.shared;

import java.io.Serializable;

public class Docente extends Utente implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	
	public Docente(String email, String password, String nomeUtente, String matricola, String nome,
			String cognome, String luogoNascita, String dataNascita, String tipologia) {
		super(email, password, nomeUtente, matricola, nome, cognome, luogoNascita, dataNascita,tipologia);
	}
	

}
