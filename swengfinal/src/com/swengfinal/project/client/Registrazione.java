package com.swengfinal.project.client;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import com.google.gwt.i18n.shared.DateTimeFormat;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
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
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;


import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Registrazione extends Composite {

	private static RegistrazioneUiBinder uiBinder = GWT.create(RegistrazioneUiBinder.class);

	@UiTemplate("Registrazione.ui.xml")
	
	interface RegistrazioneUiBinder extends UiBinder<Widget, Registrazione> {
	} 


	public Registrazione() {
		

		
		initWidget(uiBinder.createAndBindUi(this));
		listTipologia.addItem("Studente");
		listTipologia.addItem("Docente");
		listTipologia.addItem("Segreteria");
		listTipologia.addItem("Amministratore");
		
		btnHome.getElement().getStyle().setMarginRight(10, Unit.PX);
		btnHome.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnHome.getElement().getStyle().setWidth(70.0, Unit.PX);
		btnDip.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnDip.getElement().getStyle().setWidth(90.0, Unit.PX);
		btnDip.getElement().getStyle().setMarginRight(10, Unit.PX);
		btnContatti.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnContatti.getElement().getStyle().setWidth(90.0, Unit.PX);
		btnContatti.getElement().getStyle().setMarginRight(10, Unit.PX);
		btnLogin.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnLogin.getElement().getStyle().setWidth(70.0, Unit.PX);
		btnRegistrazione.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnRegistrazione.getElement().getStyle().setWidth(90.0, Unit.PX);
		btnRegistrazione.getElement().getStyle().setMarginLeft(10.0, Unit.PX);
		txtMail.getElement().getStyle().setMarginLeft(10.0, Unit.PX);
		txtPassword.getElement().getStyle().setMarginLeft(35.0, Unit.PX);
		txtNomeUtente.getElement().getStyle().setMarginLeft(35.0, Unit.PX);
		txtMatricola.getElement().getStyle().setMarginLeft(35.0, Unit.PX);
		txtNome.getElement().getStyle().setMarginLeft(35.0, Unit.PX);
		txtCognome.getElement().getStyle().setMarginLeft(35.0, Unit.PX);
		txtLuogoNascita.getElement().getStyle().setMarginLeft(35.0, Unit.PX);
		txtDataNascita.getElement().getStyle().setMarginLeft(35.0, Unit.PX);
		listTipologia.getElement().getStyle().setMarginLeft(35.0, Unit.PX);
		btnSubmit.getElement().getStyle().setHeight(40.0, Unit.PX);
		btnSubmit.getElement().getStyle().setWidth(70.0, Unit.PX);
	}

	@UiHandler("btnLogin")
	   void doClickSubmit(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new Login());
	   }
	
	@UiHandler("btnDip")
	void doClickDip(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new Dipartimenti());
	}
	
	@UiHandler("btnContatti")
	void doClickContatti(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new Contatti());
	}
	
	@UiHandler("btnHome")
	void doClickHome(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new HomePage());
	}
	@UiHandler("btnRegistrazione")
	   void doClickRegistrazione(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new Registrazione());
	   }
	
	@UiHandler("btnSubmit")
	void doClickSubmit2(ClickEvent event) {
		
		
		ArrayList<String> datiUtenti = new ArrayList<String>();
		datiUtenti.add(txtMail.getText());
		datiUtenti.add(txtPassword.getText());
		datiUtenti.add(txtNomeUtente.getText());
		datiUtenti.add(txtMatricola.getText());
		datiUtenti.add(txtNome.getText());
		datiUtenti.add(txtCognome.getText());
		datiUtenti.add(txtLuogoNascita.getText());
		datiUtenti.add(txtDataNascita.getText());
		datiUtenti.add(listTipologia.getSelectedItemText());

		
		final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
		
		
		greetingService.registrazione(datiUtenti, new AsyncCallback<String>() {
			
			public void onFailure(Throwable c) {
				Alert a = new Alert("Errore!");
				System.out.println(a);
			}
			
			@Override
			public void onSuccess(String result) {
				if(result.equals("Registrazione completata")) {
					RootPanel.get("container").clear();
					//Account.email = txtMail.getText();
					//Account.tipoAccount = 1;
				
					RootPanel.get("container").add(new HomePageUtente());
				}else {
					Alert a = new Alert("Errore!");
					System.out.println(a);
				} 	
				
			}
		});
			
	}
	
	@UiField
	Button btnLogin;
	
	@UiField
	Button btnHome;
	
	@UiField
	Button btnDip;
	
	@UiField
	Button btnContatti;
	
	@UiField
	Button btnRegistrazione;
	
	@UiField
	TextBox txtMail;
	
	@UiField
	TextBox txtPassword;
	
	@UiField
	TextBox txtNomeUtente;
	
	@UiField
	TextBox txtMatricola;
	
	@UiField
	TextBox txtNome;
	
	@UiField
	TextBox txtCognome;
	
	@UiField
	TextBox txtLuogoNascita;
	
	@UiField
	TextBox txtDataNascita;
	
	@UiField
	ListBox listTipologia;
	
	@UiField
	Button btnSubmit;
}


