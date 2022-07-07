package com.swengfinal.project.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import com.swengfinal.project.shared.Corso;
import com.swengfinal.project.shared.Esame;

public class dbEsame {
	private static DB getDB() {
		DB db = DBMaker.newFileDB(new File("dbEsame1")).make();
		return db;
	}
	
	public static String creazioneEsame(ArrayList<String> dati, int idCorso) { 
		//Alert a = new Alert("1!");
		//System.out.println(a);
		DB db = getDB();
		BTreeMap<Integer, Esame> esami = db.getTreeMap("EsamiMap");
		

		//if(!checkCorso(Integer.parseInt(dati.get(0)))) {
			Esame esame = new Esame(
					esami.size(), 					// idEsame
					idCorso,						// idCorso
					dati.get(2), 				   // data
					dati.get(3),                   // ora
					dati.get(4), 					// aula 
					dati.get(5),					//cfu
					dati.get(6),					//nome esame
					dati.get(7)                   // email docente
					);
			
			//Alert ab = new Alert("2!");
			//System.out.println(ab);
			esami.put(esame.getIdEsame(), esame);
			db.commit();
			db.close();
			
			return "Successo";			
		}
	
	public static String iscrizioneEsame(String email, int idCorso) { 
		DB db = getDB();
		BTreeMap<Integer, Esame> esami = db.getTreeMap("EsamiMap");
		
		Esame esame = esami.get(idCorso);
		boolean found = false;
		
		for(int i = 0; i < esame.getListaUtenti().size(); i++) {	
			if(esame.getListaUtenti().get(i).equals(email)) {
				found = true;
			}
		}
		if(!found) {
			esame.getListaUtenti().add(email);  // Aggiunta mail studente al relativo esame
			return "Successo";
		}else return "Errore";
	}
	
	public static String modificaEsame(ArrayList<String> dati, int idCorso) {
		DB db = getDB();
		BTreeMap<Integer, Esame> esami = db.getTreeMap("EsamiMap");
		
		
		Esame esame = esami.get(idCorso);
		esami.remove(idCorso);
		if(dati.get(0)!="")
		{
			esame.setData(dati.get(0));
		}
		if(dati.get(1)!="")
		{
			esame.setCfu(dati.get(1));
			
		}
		if(dati.get(2)!="")
		{
			esame.setAula(dati.get(2));
		}
		if(dati.get(3)!="")
		{
			esame.setOra(dati.get(3));
		}
		
		esami.put(idCorso, esame);
		db.commit();
		db.close();
		
		return "Successo";
		
	}
	
	public static String deleteEsame(int idCorso) {
		DB db = getDB();
		BTreeMap<Integer, Corso> esami = db.getTreeMap("EsamiMap");
		
		
		esami.remove(idCorso);
		db.commit();
		db.close();
		
		return "Successo";
	}
	
	public static ArrayList<String> getEsameStudente(String email){
		
		DB db = getDB();
		BTreeMap<Integer, Esame> esami = db.getTreeMap("EsamiMap");
		ArrayList<String> esamiOutput = new ArrayList<String>();
		
		for(Entry<Integer, Esame> test : esami.entrySet()) {
			for(int i=0;i<test.getValue().getListaUtenti().size();i++) {
				if(email==test.getValue().getListaUtenti().get(i)) {
					esamiOutput.add(test.getValue().getNomeEsame());
				}
			}
		}
		return esamiOutput;
	}
	
	public static ArrayList<Esame> getAllEsame(String email)
	{
		DB db = getDB();
		BTreeMap<Integer, Esame> esami = db.getTreeMap("EsamiMap");
		ArrayList<Esame> esamiOutput = new ArrayList<Esame>();
		
		for(Entry<Integer, Esame> test : esami.entrySet()) {
			if(email.equals(test.getValue().getEmailDocente())) {
					esamiOutput.add(test.getValue());
			}
		}
		return esamiOutput;
	}
}
