package com.swengfinal.project.server;

import java.io.File;
import java.util.ArrayList;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import com.swengfinal.project.shared.Esame;
import com.swengfinal.project.shared.Voto;

public class dbVoto {
	
	private static DB getDB() {
		DB db = DBMaker.newFileDB(new File("dbVoti6")).make();
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
					dati.get(0), 				   // nomeEsame
					dati.get(1),                   // matricola
					dati.get(2)                  // voto
					);
			
			//Alert ab = new Alert("2!");
			//System.out.println(ab);
			for(int i = 0; i < voti.size(); i++) {	
				String mat=(voti.get(i).getMatricola()).toString();
				/*if(mat.equals(voto.getMatricola())) {
					if(voti.get(i).getNomeEsame().equals(voto.getNomeEsame())) {
						found=true;
					}
					
				}*/
				return "Errore";
			}
			if(!found) {
				voti.put(voto.getIdVoto(), voto);
				db.commit();
				db.close();
				return "Successo";
			}else return "Errore";
			
			
			
						
		}

}
