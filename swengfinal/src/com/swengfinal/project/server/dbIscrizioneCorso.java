package com.swengfinal.project.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import com.swengfinal.project.shared.Corso;
import com.swengfinal.project.shared.IscrizioneCorso;

public class dbIscrizioneCorso {
	private static Integer tmp = 0;
	/*
	public dbIscrizioneCorso (){
		DB db = getDB();
		tmp= 
	}*/
	
	private static DB getDB() {
		DB db = DBMaker.newFileDB(new File("dbIscrizioneCorso")).make();
		return db;
	}
	
	public static String iscrizioneCorso(String email, Integer idCorso) { 
		DB db = getDB();
		BTreeMap<Integer, IscrizioneCorso> iscrizioni = db.getTreeMap("IscrizioniCorso");
		
		IscrizioneCorso iscrizione = new IscrizioneCorso(idCorso, email);
		boolean found = false;

		
	//	IscrizioneCorso id = new IscrizioneCorso(100,"tmp");
		/*
		IscrizioneCorso idSave= new IscrizioneCorso(0,"");
		for(Entry<Integer, IscrizioneCorso> test : iscrizioni.entrySet()) {
			if(test.getValue().getMailStudente()=="tmp") {
				idSave = test.getValue();
				iscrizioni.remove(test.getKey());
			}
		}
		Integer id = idSave.getIdCorso();
		
		iscrizioni.put(idSave.getIdCorso()+1, idSave);
		*/
		for(Entry<Integer, IscrizioneCorso> test : iscrizioni.entrySet()) {
			if(idCorso == test.getValue().getIdCorso() && email.equals(test.getValue().getMailStudente())) {
				found = true;
			}
		}
		
		if(!found) {
			iscrizioni.put(iscrizioni.size(), iscrizione); // Aggiunta mail studente al relativo corso
			tmp++;
			db.commit();
			db.close();
			return "Successo";
			
		} else {
			db.commit();
			db.close();
			return "Errore";
		}
		
		
	}
	
	public static ArrayList<Integer> getCorsoStudente(String email){
		DB db = getDB();
		BTreeMap<Integer, IscrizioneCorso> iscrizioni = db.getTreeMap("IscrizioniCorso");
		ArrayList<Integer> corsiOutput = new ArrayList<Integer>();
		
		for(Entry<Integer, IscrizioneCorso> test : iscrizioni.entrySet()) {
			if(email.equals(test.getValue().getMailStudente())) {
				corsiOutput.add(test.getValue().getIdCorso());
			}
		}
		return corsiOutput;
	}
}