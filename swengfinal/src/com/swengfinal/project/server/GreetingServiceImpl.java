package com.swengfinal.project.server;

import com.swengfinal.project.client.GreetingService;
import com.swengfinal.project.shared.Corso;
import com.swengfinal.project.shared.Esame;
import com.swengfinal.project.shared.FieldVerifier;
import com.swengfinal.project.shared.Studente;
import com.swengfinal.project.shared.Utente;
import com.swengfinal.project.shared.Voto;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.mapdb.Serializer;

import java.io.File;
import java.util.ArrayList;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

	// metodi utenti
	@Override
	public String registrazioneStudente(ArrayList<String> dati) throws IllegalArgumentException {
		return dbUtenti.registrazioneStudente(dati);
	}
	
	@Override
	public String registrazioneDocente(ArrayList<String> dati) throws IllegalArgumentException {
		return dbUtenti.registrazioneDocente(dati);
	}
	
	@Override
	public String registrazioneSegreteria(ArrayList<String> dati) throws IllegalArgumentException {
		return dbUtenti.registrazioneSegreteria(dati);
	}
	
	@Override
	public String registrazioneAdmin(ArrayList<String> dati) throws IllegalArgumentException {
		return dbUtenti.registrazioneAdmin(dati);
	}
	
	@Override
	public Utente login(String username, String password) {
		return dbUtenti.login(username, password);
	}

	@Override
	public String getInfoUtente(String email) throws IllegalArgumentException{
		return dbUtenti.getInfoUtente(email);
	}

	@Override
	public Utente getUtente(String email) {
		return dbUtenti.getUtente(email);
	}
	
	@Override
	public ArrayList<Utente> getStudenti(){
		return dbUtenti.getStudenti();
	}
	
	
	// metodi corso
	
	@Override
	public String creazioneCorso(ArrayList<String> dati) throws IllegalArgumentException {
		return dbCorso.creazioneCorso(dati);
	}
	@Override
	public String updateCorso(ArrayList<String> corsoUpdate, String nomeCorso) throws IllegalArgumentException {
		return dbCorso.modificaCorso(corsoUpdate, nomeCorso);
	}
	
	@Override
	public String iscrizioneCorso(String email, int idCorso) throws IllegalArgumentException {
		return dbIscrizioneCorso.iscrizioneCorso(email, idCorso);
	}
	
	@Override
	public ArrayList<Integer> getCorsoStudente(String email) throws IllegalArgumentException {
		return dbIscrizioneCorso.getCorsoStudente(email);
	}
	
	@Override
	public ArrayList<Corso> getAllCorso(String email) throws IllegalArgumentException {
		return dbCorso.getAllCorso(email);
	}
	
	@Override
	public String deleteCorso(String nomeCorso) throws IllegalArgumentException
	{
		return dbCorso.deleteCorso(nomeCorso);
	}
	
	public ArrayList<Corso> getCorsi() throws IllegalArgumentException{
		return dbCorso.getCorsi();
	}
	
	// metodi esame
	
	@Override
	public String creazioneEsame(ArrayList<String> dati, int idCorso) throws IllegalArgumentException {
		return dbEsame.creazioneEsame(dati, idCorso);
	}
	@Override
	public String updateEsame(ArrayList<String> esameUpdate, int idCorso) throws IllegalArgumentException {
		return dbEsame.modificaEsame(esameUpdate, idCorso);
	}
	
	@Override
	public String iscrizioneEsame(String email, int idCorso) throws IllegalArgumentException {
		return dbIscrizioneEsame.iscrizioneEsame(idCorso, email);
	}
	
	@Override
	public ArrayList<Integer> getEsameStudente(String email) throws IllegalArgumentException {
		return dbIscrizioneEsame.getEsamiStudente(email);
	}
	
	@Override
	public ArrayList<Esame> getAllEsame(String email) throws IllegalArgumentException
	{
		return dbEsame.getAllEsame(email);
	}
	
	@Override
	public String deleteEsame(int idCorso) throws IllegalArgumentException
	{
		return dbEsame.deleteEsame(idCorso);
	}
	
	@Override
	public ArrayList<Esame> getEsami() throws IllegalArgumentException
	{
		return dbEsame.getEsami();
	}
	
	//metodo invio voto
	
	@Override
	public String addVoto(ArrayList<String> dati ) throws IllegalArgumentException {
		return dbVoto.addVoto(dati);
	}
	
	@Override
	public ArrayList<Voto> getVoto(String matricola) throws IllegalArgumentException {
		return dbVoto.getVoto(matricola);
	}
	
}
