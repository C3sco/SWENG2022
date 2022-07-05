package com.swengfinal.project.shared;

import java.util.ArrayList;
import java.util.List;

public class Corso {
		
	private static int idCorso; 
	private static int idDocente;
	private static String nomeCorso;
	private static String descrizione;
	private static String dataInizio;
	private static String dataFine;
	
	private static List<String> listaUtenti; 
	
	public Corso() {
	}
	
	public Corso(int idCorso, int idDocente, String nomeCorso, String descrizione, String dataInizio, String dataFine) {
		this.idCorso = idCorso;
		this.idDocente = idDocente;
		this.nomeCorso = nomeCorso;
		this.descrizione = descrizione;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		
		listaUtenti = new ArrayList<>();
	}
	
	public static List<String> getListaUtenti() {
		return listaUtenti;
	}
	
	
	public static int getIdCorso() {
		return idCorso;
	}
	public static void setIdCorso(int idCorso) {
		Corso.idCorso = idCorso;
	}
	
	public static int getIdDocente() {
		return idDocente;
	}
	public static void setIdDocente(int idDocente) {
		Corso.idDocente = idDocente;
	}
	
	public static String getNomeCorso() {
		return nomeCorso;
	}
	public static void setNomeCorso(String nomeCorso) {
		Corso.nomeCorso = nomeCorso;
	}
	
	public static String getDescrizione() {
		return descrizione;
	}
	public static void setDescrizione(String descrizione) {
		Corso.descrizione = descrizione;
	}
	
	public static String getDataInizio() {
		return dataInizio;
	}
	public static void setDataInizio(String dataInizio) {
		Corso.dataInizio = dataInizio;
	}
	
	public static String getDataFine() {
		return dataFine;
	}
	public static void setDataFine(String dataFine) {
		Corso.dataFine = dataFine;
	}
}
