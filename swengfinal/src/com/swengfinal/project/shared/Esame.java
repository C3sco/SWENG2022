package com.swengfinal.project.shared;

public class Esame {

	private static int idEsame;
	private static int idCorso; 
	private static String data; 
	private static String ora; 
	private static String aula;
	
	public Esame(int idEsame, int idCorso, String data, String ora, String aula) {
		this.idEsame = idEsame;
		this.idCorso = idCorso;
		this.data = data;
		this.ora = ora;
		this.aula = aula;
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
}
