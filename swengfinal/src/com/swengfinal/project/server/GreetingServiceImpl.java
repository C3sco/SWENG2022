package com.swengfinal.project.server;

import com.swengfinal.project.client.GreetingService;
import com.swengfinal.project.shared.FieldVerifier;
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


	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException("Name must be at least 4 characters long");
		}
		return "SIUM";
	}
	
	@Override
	public String registrazione(ArrayList<String> dati) throws IllegalArgumentException {
		return dbUtenti.registrazione(dati);
	}
	
	@Override
	public int login(String username, String password) {
		return dbUtenti.login(username, password);
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}
}
