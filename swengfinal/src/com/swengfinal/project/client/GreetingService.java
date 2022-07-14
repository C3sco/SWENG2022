package com.swengfinal.project.client;

import java.util.ArrayList;


import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.swengfinal.project.shared.Corso;
import com.swengfinal.project.shared.Docente;
import com.swengfinal.project.shared.Esame;
import com.swengfinal.project.shared.Studente;
import com.swengfinal.project.shared.Utente;
import com.swengfinal.project.shared.Voto;


/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	
	/**
	 * Metodi utente
	 */
	
	/**
	 * Metodo per la registrazione dello studente, prende in input un ArrayList con i dati dello studente
	 * e restituisce un messaggio se l'operazione è andata a buon fine o meno
	 **/
	String registrazioneStudente(ArrayList<String> dati) throws IllegalArgumentException;
	
	/**
	 * Metodo per la registrazione della segretaria, prende in input un ArrayList con i dati
	 * dell'account della segreteria e restituisce un messaggio se l'operazione è andata a buon fine o meno
	 **/
	String registrazioneSegreteria(ArrayList<String> dati) throws IllegalArgumentException;
	
	/**
	 * Metodo per la registrazione dell'admin, prende in input un ArrayList con i dati dell'admin
	 * e restituisce un messaggio se l'operazione è andata a buon fine o meno
	 **/
	String registrazioneAdmin(ArrayList<String> dati) throws IllegalArgumentException;
	
	/**
	 * Metodo per la registrazione del docente, prende in input un ArrayList con i dati del docente
	 * e restituisce un messaggio se l'operazione è andata a buon fine o meno
	 **/
	String registrazioneDocente(ArrayList<String> dati) throws IllegalArgumentException;
	
	/**
	 * Metodo per la gestione del login, prende in input la mail e la password scritti nel form
	 * e restituisce un oggetto di tipo utente se l'operazione è andata a buon fine o meno
	 **/
	Utente login(String username, String password) throws IllegalArgumentException;
	
	/**
	 * Metodo che restituisce le informazioni dell'utente, verificando la mail passata in input restituisce 
	 * i dati dell'utente se l'operazione è andata a buon fine
	 **/
	String getInfoUtente(String email)throws IllegalArgumentException;
	
	/**
	 * Metodo che restituisce un utente la cui mail corrisponde a quella passata in input
	 **/
	Utente getUtente(String email) throws IllegalArgumentException;
	
	/**
	 * Metodo che restituisce le informazioni dell'utente, verificando la mail passata in input restituisce 
	 * i dati dell'utente se l'operazione è andata a buon fine
	 **/
	ArrayList<Studente> getStudenti() throws IllegalArgumentException;
	
	/**
	 * Metodo che restituisce una lista con tutti i docenti registrati
	 **/
	ArrayList<Docente> getDocenti() throws IllegalArgumentException;
	
	/**
	 * Metodo che restituisce una lista con tutti i docenti registrati
	 **/
	ArrayList<Utente> getUtentiAll() throws IllegalArgumentException;
	
	/**
	 * Metodo che elimina l'utente, la cui mail corrisponde a quella passata input
	 **/
	String deleteUtente(String email) throws IllegalArgumentException;
	
	/**
	 * Metodo si occupa di modificare l'utente, la cui mail corrisponde a quella passata input e insieme ai dati da aggiornare
	 **/
	String updateUtente(ArrayList<String> utenteUpdate, String email) throws IllegalArgumentException;
	
	/**
	 * Metodi corso
	 */
	String creazioneCorso(ArrayList<String> dati) throws IllegalArgumentException;
	
	String updateCorso(ArrayList<String> corsoUpdate, String nomeCorso) throws IllegalArgumentException;
	
	String iscrizioneCorso(String email, int idCorso) throws IllegalArgumentException;
	
	ArrayList<Corso> getAllCorso(String email) throws IllegalArgumentException;
	
	ArrayList<Integer> getCorsoStudente(String email) throws IllegalArgumentException;
	
	String deleteCorso(String nomeCorso) throws IllegalArgumentException;
	
	/**
	 * Metodi esame
	 */
	String creazioneEsame(ArrayList<String> dati, int idCorso) throws IllegalArgumentException;
	
	String updateEsame(ArrayList<String> esameUpdate, int idCorso) throws IllegalArgumentException;
	
	String iscrizioneEsame(String email, int idCorso) throws IllegalArgumentException;
	
	ArrayList<Esame> getAllEsame(String email) throws IllegalArgumentException;
	
	ArrayList<Esame> getEsami() throws IllegalArgumentException;
	
	ArrayList<Integer> getEsameStudente(String email) throws IllegalArgumentException;
	
	String deleteEsame(int idCorso) throws IllegalArgumentException;
	
	ArrayList<Corso> getCorsi() throws IllegalArgumentException;
	
	ArrayList<String> getIscrizioniEsame(Integer idEsame) throws IllegalArgumentException;
	
	/**
	 * Metodi voto
	 */
	String addVoto(ArrayList<String> dati) throws IllegalArgumentException;
	
	ArrayList<Voto> getVoto(String matricola) throws IllegalArgumentException;
	
	ArrayList<Voto> getVotoAll() throws IllegalArgumentException;
	
	String votoPubblicato(ArrayList<String> dati) throws IllegalArgumentException;
	
	String getDatabase() throws IllegalArgumentException;
	
	String eliminaVoto(Voto voto)  throws IllegalArgumentException;
}


