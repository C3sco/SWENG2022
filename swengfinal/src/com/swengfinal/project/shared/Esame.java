package com.swengfinal.project.shared;

import java.util.ArrayList;
import java.util.List;

public class Esame {

	private static int idEsame;
	private static int idCorso; 
	private static String data; 
	private static String ora; 
	private static String aula;
	private static String cfu;
	private static String nomeEsame;
	private static String emailDocente;
	private List<String> listaUtenti; 
	
	public Esame(int idEsame, int idCorso, String data, String ora, String aula, String cfu, String nomeEsame, String emailDocente) {
		this.idEsame = idEsame;
		this.idCorso = idCorso;
		this.data = data;
		this.ora = ora;
		this.aula = aula;
		this.cfu=cfu;
		this.nomeEsame=nomeEsame;
		this.emailDocente=emailDocente;
		
		listaUtenti = new ArrayList<>();
	}
	
	public List<String> getListaUtenti() {
		return listaUtenti;
	}
	
	public static int getIdEsame() {
		return idEsame;
	}
	public static void setIdEsame(int idEsame) {
		Esame.idEsame = idEsame;
	}
	
	public static int getIdCorso() {
		return idCorso;
	}
	public static void setIdCorso(int idCorso) {
		Esame.idCorso = idCorso;
	}
	
	public static String getData() {
		return data;
	}
	public static void setData(String data) {
		Esame.data = data;
	}
	
	public static String getOra() {
		return ora;
	}
	public static void setOra(String ora) {
		Esame.ora = ora;
	}
	
	public static String getAula() {
		return aula;
	}
	public static void setAula(String aula) {
		Esame.aula = aula;
	}
	
	public static String getEmailDocente() {
		return emailDocente;
		
	}
	public static void setEmailDocente(String emailDocente) {
		Esame.emailDocente=emailDocente;
	}
	public static String getCfu() {
		return cfu;
	}
	public static void setCfu(String cfu) {
		Esame.cfu = cfu;
	}
	
	public static String getNomeEsame() {
		return nomeEsame;
	}
	
	public static void setNomeEsame(String nomeEsame) {
		Esame.nomeEsame = nomeEsame;
	}
}
