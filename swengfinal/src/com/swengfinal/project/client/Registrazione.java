package com.swengfinal.project.client;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import com.google.gwt.i18n.shared.DateTimeFormat;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;


import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Registrazione extends Composite {

	private static RegistrazioneUiBinder uiBinder = GWT.create(RegistrazioneUiBinder.class);

	interface RegistrazioneUiBinder extends UiBinder<Widget, Registrazione> {
	} 
	
	/**
	 * Classe per la definizione della Registrazione_Page
	 * registra le informazioni dell'utente nella fase di registrazione
	 * @author Giacomo Rondelli, Gabriele Malossi
	 */

	public Registrazione() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
