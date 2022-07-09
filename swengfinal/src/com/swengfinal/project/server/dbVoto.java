package com.swengfinal.project.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import com.swengfinal.project.shared.Corso;
import com.swengfinal.project.shared.Esame;
import com.swengfinal.project.shared.Voto;

public class dbVoto {
	
	private static DB getDB() {
		DB db = DBMaker.newFileDB(new File("dbVoti7")).make();
		return db;
	}
	
	public static String addVoto(ArrayList<String> dati) { 
		//Alert a = new Alert("1!");
		//System.out.println(a);
		DB db = getDB();
		BTreeMap<Integer, Voto> voti = db.getTreeMap("VotiMap");
		
		boolean found = false;
		
		

		//if(!checkCorso(Integer.parseInt(dati.get(0)))) {
			Voto voto = new Voto(
					voti.size(),
					dati.get(1), 				   // nomeEsame
					dati.get(2),                   // matricola
					dati.get(3),                  // voto
					false);
			
			
			for(Entry<Integer, Voto> test : voti.entrySet()) {
				if(test.getValue().getMatricola().equals(voto.getMatricola()) && test.getValue().getNomeEsame().equals(voto.getNomeEsame())) {
					found=true; //ritorna id del Corso
				}
			}
			if(!found) {
				voti.put(voto.getIdVoto(), voto);
				db.commit();
				db.close();
				return "Successo";
			}else return "Errore";
			
			
			
						
		}

}
