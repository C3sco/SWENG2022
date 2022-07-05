package com.swengfinal.project.server;

import com.swengfinal.project.client.GreetingService;
import com.swengfinal.project.shared.FieldVerifier;
import com.swengfinal.project.shared.Utente;
import com.swengfinal.project.shared.Amministratore;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.mapdb.Serializer;

import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;

public class dbUtenti {
	private static DB getDB() {
		DB db = DBMaker.newFileDB(new File("dbSWENG")).make();
		return db;
	}
	
	private static boolean checkMail(String email) {
		boolean find = false;
		DB db = getDB();
		BTreeMap<String,Utente> Users = db.getTreeMap("UtentiMap");
		for(Entry<String,Utente> test : Users.entrySet()) {
			if(test.getValue().getEmail().equalsIgnoreCase(email)) {
				find = true;
			}
		} return find;
	}
	
	public static String registrazione(ArrayList<String> dati) {
		DB db = getDB();
		System.out.println(getDB().getAll());
		BTreeMap<String,Utente> Users;
		
		if(!checkMail(dati.get(0))) {
			Users = db.getTreeMap("UtentiMap");
			
			Utente user = new Utente(dati.get(0),dati.get(1),dati.get(2),dati.get(3),
						dati.get(4),
						dati.get(5),
						dati.get(6),
						dati.get(7), 
						dati.get(8));
			
			Users.put(user.getEmail(),user);
			db.commit();
			db.close();
			return "Successo";
		}
		else return "Errore";
	}
	
	public static int login(String email, String password) throws IllegalArgumentException{
		DB db = getDB();
		BTreeMap<String,Utente> Users = db.getTreeMap("UtentiMap");
		
		if(checkMail(email)) {
			Utente user = Users.get(email);
			if(user.getPw().equals(password)) {
				if((user.getClass()==Utente.class)) return 1;
				//if((user.getClass()==Amminsitratore.class)) return 2;
			}
			else {
				return -1;
			}
		}
		return 0;
	}
	public static String getInfoUtente(String email) {

		DB db = getDB();
		BTreeMap<String, Utente> UtentiMap = db.getTreeMap("mappaUtenti");

		Utente u = UtentiMap.get(email);

		String info = "Username :" + u.getNomeUtente() + "\nEmail : " + email + 
				"\nNome : " + u.getNome() + "\nCognome : " + u.getCognome()
				 + "\nData Nascita : " + u.getDataNascita()
				+ "\nLuogo Nascita : " + u.getLuogoNascita();


		return info;
	}

}
