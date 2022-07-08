package com.swengfinal.project.shared;

import java.io.Serializable;

public class Voto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nomeEsame;
	private String matricola;
	private int voto;
	
	public Voto() {}
	
	public Voto(String nomeEsame, String matricola, int voto) {
		this.nomeEsame=nomeEsame;
		this.matricola=matricola;
		this.voto=voto;
	}
	
	public String getMatricola() {
		return matricola;
	}
	
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
	public String getNomeEsame() {
		return nomeEsame;
	}
	
	public void setNomeEsame(String nomeEsame) {
		this.nomeEsame = nomeEsame;
	}
	
	public int getVoto() {
		return voto;
	}
	
	public void setVoto(int voto) {
		this.voto = voto;
	}
}
