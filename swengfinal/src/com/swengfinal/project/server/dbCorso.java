package com.swengfinal.project.server;


import com.swengfinal.project.shared.Corso;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;


public class dbCorso {

	private static DB getDB() {
		DB db = DBMaker.newFileDB(new File("dbCorso")).make();
		return db;
	}
	/*
	private static boolean checkCorso(Integer idCorso) { //se corso esiste allora ritorna true
		boolean find = false;
		
		DB db = getDB();
		BTreeMap<Integer, Corso> corsi = db.getTreeMap("CorsiMap"); //mappa che potrebbe indicarmi tutti i corsi
		
		for(Entry<Integer, Corso> test : corsi.entrySet()) {
			if(test.getValue().getIdCorso() == idCorso) {
				find = true;
			}
		}
		return find;
	}*/
	
	private static int posizioneCorso( String nomeCorso)
	{
		DB db = getDB();
		BTreeMap<Integer, Corso> corsi = db.getTreeMap("CorsiMap");
		for(Entry<Integer, Corso> test : corsi.entrySet()) {
			if(test.getValue().getNomeCorso().equals(nomeCorso)) {
				return test.getValue().getIdCorso(); //ritorna id del Corso
			}
		}
		return 0;
	}
	
	public static String creazioneCorso(ArrayList<String> dati) { 
		//Alert a = new Alert("1!");
		//System.out.println(a);
		DB db = getDB();
		BTreeMap<Integer, Corso> corsi = db.getTreeMap("CorsiMap");
		

		//if(!checkCorso(Integer.parseInt(dati.get(0)))) {
			Corso corso = new Corso(
					corsi.size(), 			   // idCorso
					dati.get(1), 				   // mailDocente
					dati.get(2),                   // nomeCorso
					dati.get(3),                   // Descrizione Corso
					dati.get(4),                   // data inizio corso
					dati.get(5),                    // data fine corso 
					dati.get(6)
					);
			
			//Alert ab = new Alert("2!");
			//System.out.println(ab);
			corsi.put(corso.getIdCorso(), corso);
			db.commit();
			db.close();
			
			return "Successo";			
		}
		
	
	/*  */

	public static String iscrizioneCorso(String email, int idCorso) { 
		DB db = getDB();
		BTreeMap<Integer, Corso> corsi = db.getTreeMap("CorsiMap");
		
		Corso corso = corsi.get(idCorso);
		boolean found = false;
		
		for(int i = 0; i < corso.getListaUtenti().size(); i++) {	
			if(corso.getListaUtenti().get(i).equals(email)) {
				found = true;
			}
		}
		if(!found) {
			corso.getListaUtenti().add(email);  // Aggiunta mail studente al relativo corso
			db.commit();
			db.close();
			return "Successo";
			
		}else return "Errore";
		
	}

	
	public static String modificaCorso(ArrayList<String> dati, String nomeCorso) {
		DB db = getDB();
		BTreeMap<Integer, Corso> corsi = db.getTreeMap("CorsiMap");
		
		int idCorso=posizioneCorso(nomeCorso);
		Corso corso = corsi.get(idCorso);
		corsi.remove(idCorso);
		if(dati.get(0)!="")
		{
			corso.setDescrizione(dati.get(0));
		}
		if(dati.get(1)!="")
		{
			corso.setDataInizio(dati.get(1));
			
		}
		if(dati.get(2)!="")
		{
			corso.setDataFine(dati.get(2));
		}
		if(dati.get(3)!="")
		{
			corso.setCoDocente(dati.get(3));
		}
		
		corsi.put(idCorso, corso);
		db.commit();
		db.close();
		
		return "Successo";
		
	}
	
	public static String deleteCorso(String nomeCorso) {
		DB db = getDB();
		BTreeMap<Integer, Corso> corsi = db.getTreeMap("CorsiMap");
		
		int idCorso=posizioneCorso(nomeCorso);
		corsi.remove(idCorso);
		db.commit();
		db.close();
		
		return "Successo";
	}

	
	
	
	public static ArrayList<Corso> getAllCorso(String email)
	{
		DB db = getDB();
		BTreeMap<Integer, Corso> corsi = db.getTreeMap("CorsiMap");
		ArrayList<Corso> corsiOutput = new ArrayList<Corso>();
		
		for(Entry<Integer, Corso> test : corsi.entrySet()) {
			if(email.equals(test.getValue().getEmailDocente())) {
					corsiOutput.add(test.getValue());
			}
		}
		return corsiOutput;
	}
	
	public static ArrayList<Corso> getCorsi(){
		DB db = getDB();
		BTreeMap<Integer, Corso> corsi = db.getTreeMap("CorsiMap");
		ArrayList<Corso> corsiAll = new ArrayList<Corso>();
		for(Entry<Integer, Corso> test : corsi.entrySet()) {
			corsiAll.add(test.getValue());
		}
		
		return corsiAll;
	}
}
