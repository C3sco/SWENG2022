package com.swengfinal.project.server;

import java.io.File;
import java.util.ArrayList;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.util.Map.Entry;

import com.swengfinal.project.shared.Corso;

public class dbCorso {

	private static DB getDB() {
		DB db = DBMaker.newFileDB(new File("dbCorsi")).make();
		return db;
	}
	
	private static boolean checkCorso(Integer idCorso) {
		boolean find = false;
		
		DB db = getDB();
		BTreeMap<Integer, Corso> corsi = db.getTreeMap("CorsiMap");
		
		for(Entry<Integer, Corso> test : corsi.entrySet()) {
			if(test.getValue().getIdCorso() == idCorso) {
				find = true;
			}
		}
		return find;
	}
	
	public static String creazioneCorso(ArrayList<String> dati) { 
		DB db = getDB();
		BTreeMap<Integer, Corso> corsi = db.getTreeMap("CorsiMap");

		if(!checkCorso(Integer.parseInt(dati.get(0)))) {
			Corso corso = new Corso(
					Integer.parseInt(dati.get(0)), // idCorso
					Integer.parseInt(dati.get(1)), // idDocente
					dati.get(2),                   // nomeCorso
					dati.get(3),                   // Descrizione Corso
					dati.get(4),                   // data inizio corso
					dati.get(5)                    // data fine corso 
					);
			
			corsi.put(corso.getIdCorso(), corso);
			db.commit();
			db.close();
			
			return "Corso creato con successo.";			
		} else {
			return "Creazione corso non avvenuta";
		}
		
	} 
	
	public static void iscrizioneCorso(String email, int idCorso) { 
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
			corso.getListaUtenti().add(email);
		}	
	}
	
	public static void modificaCorso() {
		DB db = getDB();
		BTreeMap<Integer, Corso> corsi = db.getTreeMap("CorsiMap");
		
		
	}
}
