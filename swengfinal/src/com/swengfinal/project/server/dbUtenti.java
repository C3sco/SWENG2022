package com.swengfinal.project.server;


import com.swengfinal.project.client.Alert;
import com.swengfinal.project.shared.Amministratore;
import com.swengfinal.project.shared.Docente;
import com.swengfinal.project.shared.Segreteria;
import com.swengfinal.project.shared.Studente;
import com.swengfinal.project.shared.Utente;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;


/* db.getAll().clear()	per pulire il db */

public class dbUtenti {
	private static DB getDB() {
		DB db = DBMaker.newFileDB(new File("dbUsers")).make();
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
	
	public static String registrazioneStudente(ArrayList<String> dati) {
		DB db = getDB();
		BTreeMap<String,Utente> Users;
		
		if(!checkMail(dati.get(0))) {
			Users = db.getTreeMap("UtentiMap");
			
			Studente user = new Studente(dati.get(0),dati.get(1),dati.get(2),dati.get(3),
						dati.get(4),
						dati.get(5),
						dati.get(6));
			
			
			Users.put(user.getEmail(),user);
			db.commit();
			db.close();
			//Alert gg = new Alert("Utente registrato con mail: " + user.getEmail() + " e password: " + user.getPw());
			return "Registrazione completata";
		}
		else return "Errore";
	}
	
	public static String registrazioneDocente(ArrayList<String> dati) {
		DB db = getDB();
		BTreeMap<String,Utente> Users;
		
		if(!checkMail(dati.get(0))) {
			Users = db.getTreeMap("UtentiMap");
			
			Docente user = new Docente(dati.get(0),dati.get(1),dati.get(2),dati.get(3),
						dati.get(4),
						dati.get(5));
			
			Users.put(user.getEmail(),user);
			db.commit();
			db.close();
			//Alert gg = new Alert("Utente registrato con mail: " + user.getEmail() + " e password: " + user.getPw());
			return "Registrazione completata";
		}
		else return "Errore";
	}
	
	public static String registrazioneAdmin(ArrayList<String> dati) {
		DB db = getDB();
		BTreeMap<String,Utente> Users;
		
		if(!checkMail(dati.get(0))) {
			Users = db.getTreeMap("UtentiMap");
			
			Amministratore user = new Amministratore(dati.get(0),dati.get(1),dati.get(2),dati.get(3),
						dati.get(4),
						dati.get(5));
			
			Users.put(user.getEmail(),user);
			db.commit();
			db.close();
			//Alert gg = new Alert("Utente registrato con mail: " + user.getEmail() + " e password: " + user.getPw());
			return "Registrazione completata";
		}
		else return "Errore";
	}
	
	public static String registrazioneSegreteria(ArrayList<String> dati) {
		DB db = getDB();
		BTreeMap<String, Utente> Users;
		
		if(!checkMail(dati.get(0))) {
			Users = db.getTreeMap("UtentiMap");
			
			Segreteria user = new Segreteria(dati.get(0),dati.get(1),dati.get(2),dati.get(3),
						dati.get(4),
						dati.get(5));
			
			Users.put(user.getEmail(),user);
			db.commit();
			db.close();
			//Alert gg = new Alert("Utente registrato con mail: " + user.getEmail() + " e password: " + user.getPw());
			return "Registrazione completata";
		}
		else return "Errore";
	}
	
	public static Utente login(String email, String password) throws IllegalArgumentException{
		
		DB db = getDB();
		BTreeMap<String,Utente> Users = db.getTreeMap("UtentiMap");
		if(checkMail(email)) {
			Utente user = Users.get(email);
			if(user.getPw().equals(password)) {
				return user;
			}else return null;
		}else return null;
	}
			
			//Alert a = new Alert("Test");
			//System.out.println(a + user.getTipologia());
				
				/*
				if(user.getTipologia().equals("Utente")) {
					return 1;
				}else if(user.getTipologia()=="Segreteria") {
					return 3;
				}else if(user.getTipologia()=="Docente") {
					return 4;
				}else if(user.getTipologia()=="Amministratore") {
					return 2;
				}else {
					return -2;
				}
				//if((user.getClass()==Utente.class)) return 1;
				//if((user.getClass()==Amminsitratore.class)) return 2;
			}else return 5;
		}else return 6;*/
	
	
	public static String getInfoUtente(String email) {
		DB db = getDB();
		BTreeMap<String, Utente> Users = db.getTreeMap("UtentiMap");

		Utente user = Users.get(email);

		String all = "Email :" + user.getEmail() + "\nPassword : " + user.getPw() + "\nUsername : " + 
				"\nMatricola : " + "\nNome : " + user.getNome() + "\nCognome : " + user.getCognome()
				 + "\nData Nascita : " + user.getDataNascita()
				+ "\nLuogo Nascita : " + user.getLuogoNascita() + "\nTipologia";
		return all;
	}
	
	public static Utente getUtente(String email) {
		DB db = getDB();
		BTreeMap<String, Utente> Users = db.getTreeMap("UtentiMap");
		Utente user = Users.get(email);
		return user;

	}
	
	public static ArrayList<Studente> getStudenti(){
		DB db = getDB();
		BTreeMap<String, Utente> Users = db.getTreeMap("UtentiiMap");
		ArrayList<Studente> output = new ArrayList<Studente>();
		for(Entry<String,Utente> test : Users.entrySet()) {
			//if(test.getValue() instanceof Studente) {
				output.add((Studente) test.getValue());
			//}
		}
		return output;
	}
	
	public static ArrayList<Utente> getDocenti(){
		DB db = getDB();
		BTreeMap<String, Utente> Users = db.getTreeMap("UtentiiMap");
		ArrayList<Utente> output = new ArrayList<Utente>();
		for(Entry<String,Utente> test : Users.entrySet()) {
			//if(test.getValue() instanceof Docente) {
				output.add(test.getValue());
			//}
		}
		return output;
		
	}

}
