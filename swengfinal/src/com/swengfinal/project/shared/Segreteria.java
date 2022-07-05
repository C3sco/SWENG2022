package com.swengfinal.project.shared;

import java.io.Serializable;

public class Segreteria extends Utente implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String email;
	private String password;
	
	
	public Segreteria(String email, String password) {
		this.email = email;
		this.password = password;		
	}
	
	
}
