package com.swengfinal.project.shared;

import java.io.Serializable;
import java.util.ArrayList;

public class Segreteria extends Utente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	ArrayList<Voto> voti;
	
	public Segreteria(String email, String password, String nome,
			String cognome, String luogoNascita, String dataNascita) {
		super(email, password, nome, cognome, luogoNascita, dataNascita);
		voti=new ArrayList<Voto>();
	}
	
	public ArrayList<Voto> getVoti() {
		return voti;
	}
	
	public void setVoti(ArrayList<Voto> voti) {
		this.voti = voti;
	}
}
