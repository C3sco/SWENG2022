package com.swengfinal.project.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Corso implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
	private int idCorso; 
	private String emailDocente;
	private String nomeCorso;
	private String descrizione;
	private String dataInizio;
	private String dataFine;
	private String coDocente;
	
	private List<String> listaUtenti; 
	
	public Corso() {
	}
	
	public Corso(int idCorso, String emailDocente, String nomeCorso, String descrizione, String dataInizio, String dataFine, String coDocente) {
		this.idCorso = idCorso;
		this.emailDocente = emailDocente;
		this.nomeCorso = nomeCorso;
		this.descrizione = descrizione;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.coDocente = coDocente;
		
		listaUtenti = new ArrayList<>();
	}
	
	public List<String> getListaUtenti() {
		return listaUtenti;
	}
	
	
	public int getIdCorso() {
		return idCorso;
	}
	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}
	
	public String getEmailDocente() {
		return emailDocente;
	}
	public void setEmailDocente(String emailDocente) {
		this.emailDocente = emailDocente;
	}
	
	public String getNomeCorso() {
		return nomeCorso;
	}
	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public String getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}
	
	public String getDataFine() {
		return dataFine;
	}
	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}
	public String getCoDocente() {
		return coDocente;
	}
}
