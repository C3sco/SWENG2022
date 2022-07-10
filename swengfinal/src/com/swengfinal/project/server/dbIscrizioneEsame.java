package com.swengfinal.project.server;
import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import com.swengfinal.project.shared.Esame;
import com.swengfinal.project.shared.IscrizioneEsame;


public class dbIscrizioneEsame {
	
	private static DB getDB() {
		DB db = DBMaker.newFileDB(new File("dbIscrizioneEsame5")).make();
		return db;
	}
	public static String iscrizioneEsame(Integer idEsame, String email) { 
		DB db = getDB();
		BTreeMap<Integer, IscrizioneEsame> iscrizioniEsami = db.getTreeMap("IscrizioniEsame");
		
		IscrizioneEsame iscrizione = new IscrizioneEsame(idEsame, email);
		boolean found = false;
		
		
		for(int i = 0; i <iscrizioniEsami.size(); i++) {	
			if((iscrizioniEsami.get(i).getIdEsame()==idEsame) && (iscrizioniEsami.get(i).getMailStudente().equals(email))) {
				found = true;
			}
		}
		if(!found) {
			iscrizioniEsami.put(idEsame, iscrizione); // Aggiunta mail studente al relativo corso
			db.commit();
			db.close();
			return "Successo";
			
		}else 
		db.commit();
		return "Errore";
	}
	
	
	public static ArrayList<Integer> getEsamiStudente(String email){
		
		DB db = getDB();
		BTreeMap<Integer, IscrizioneEsame> iscrizioniEsami = db.getTreeMap("IscrizioniEsame");
		ArrayList<Integer> esamiOutput = new ArrayList<Integer>();
		
		for(Entry<Integer, IscrizioneEsame> test : iscrizioniEsami.entrySet()) {
			if(email.equals(test.getValue().getMailStudente())) {
				esamiOutput.add(test.getValue().getIdEsame());
			}
		}
		return esamiOutput;
	}
	
	
	public static ArrayList<IscrizioneEsame> getIscrizioni(){
		DB db = getDB();
		BTreeMap<Integer, IscrizioneEsame> iscrizioni = db.getTreeMap("IscrizioniEsame");
		ArrayList<IscrizioneEsame> iscrizioniAll = new ArrayList<IscrizioneEsame>();
		for(Entry<Integer, IscrizioneEsame> test : iscrizioni.entrySet()) {
			iscrizioniAll.add(test.getValue());
		}
		
		return iscrizioniAll;
	}
	
	
	/* Metodo che mi restituisce le mail degli studenti dato un esame, lo utilizziamo
	 * nella pagina PageVotiDocenti
	 */
	public static ArrayList<String> getIscrizioniEsame(Integer idEsame){
		DB db = getDB();
		BTreeMap<Integer, IscrizioneEsame> iscrizioni = db.getTreeMap("IscrizioniEsame");
		ArrayList<String> mailIscritti = new ArrayList<String>();
		for(Entry<Integer,IscrizioneEsame> test : iscrizioni.entrySet()) {
			if(test.getValue().getIdEsame()==idEsame) {
				mailIscritti.add(test.getValue().getMailStudente());
			}
		}
		return mailIscritti;
	}
	
	
	
	
	

}
