package com.swengfinal.project.server;

import com.swengfinal.project.client.GreetingService;
import com.swengfinal.project.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.mapdb.Serializer;

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


		DB db = DBMaker.fileDB(DB_FILE).make();

		// creo una semplice mappa String -> String nel db
		// il tipo HTreeMap è thread safe
		HTreeMap<String, Integer> map = db.hashMap(SIMPLE_MAP).keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.INTEGER).createOrOpen();

		if (map.containsKey(input)) {
			System.out.println(input + " contenuto inviato " + map.get(input) + " volte!");
			map.put(input, map.get(input) + 1);
		} else {
			System.out.println(input + " non presente nel DB! Aggiungo!");
			map.put(input, 1);

		}

		db.close();
		return escapeHtml("Ciao " + input + "!");
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
