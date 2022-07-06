package com.swengfinal.project.server;

import com.swengfinal.project.client.Alert;
import com.swengfinal.project.shared.Corso;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;


public class dbCorso {

	private static DB getDB() {
		DB db = DBMaker.newFileDB(new File("dbCorsi")).make();
		return db;
	}
	
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
	}
	
	private static int posizioneCorso(ArrayList<String> dati, String nomeCorso)
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
					Integer.parseInt(dati.get(0)), // idCorso
					dati.get(1), 				   // mailDocente
					dati.get(2),                   // nomeCorso
					dati.get(3),                   // Descrizione Corso
					dati.get(4),                   // data inizio corso
					dati.get(5)                    // data fine corso 
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
			return "Successo";
		}else return "Errore";
	}
	
	public static String modificaCorso(ArrayList<String> dati, String nomeCorso) {
		DB db = getDB();
		BTreeMap<Integer, Corso> corsi = db.getTreeMap("CorsiMap");
		if(checkCorso(Integer.parseInt(dati.get(0))))
		{
			int idCorso=posizioneCorso(dati,nomeCorso);
			Corso corso = corsi.get(idCorso);
			if(dati.get(3)!="")
			{
				corso.setDescrizione(dati.get(3));
			}
			if(dati.get(4)!="")
			{
				corso.setDataInizio(dati.get(4));
			}
			if(dati.get(5)!="")
			{
				corso.setDataFine(dati.get(5));
			}
				
				/*data inizio,data fine,descrizione*/
			
		}
		/*
		 * Possiamo fare in diversi modi:
		 * 1° carichiamo tutti i dati delle varie textbox e li inseriamo come se fosse un nuovo corso
		 * 2° carichiamo carichiamo solo i dati che non sono vuoti nelle textbox altrimenti carichiamo quelli del corso
		 * per fare ci� dobbiamo fare degli if a cascata per controllare ogni singolo campo
		 * 
		 */
		return "Corso modificato";
		
	}

	public static ArrayList<String> getCorsoStudente(String email){
		
		DB db = getDB();
		BTreeMap<Integer, Corso> corsi = db.getTreeMap("CorsiMap");
		ArrayList<String> corsiOutput = new ArrayList<String>();
		
		for(Entry<Integer, Corso> test : corsi.entrySet()) {
			for(int i=0;i<test.getValue().getListaUtenti().size();i++) {
				if(email==test.getValue().getListaUtenti().get(i)) {
					corsiOutput.add(test.getValue().getNomeCorso());
				}
			}
		}
		return corsiOutput;
	}
}
