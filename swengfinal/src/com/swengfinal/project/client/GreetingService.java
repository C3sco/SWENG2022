package com.swengfinal.project.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	String greetServer(String name) throws IllegalArgumentException;
	
	String registrazione(ArrayList<String> dati) throws IllegalArgumentException;
	
	int login(String username, String password) throws IllegalArgumentException;
	
	String getInfoUtente(String email) throws IllegalArgumentException;
}


