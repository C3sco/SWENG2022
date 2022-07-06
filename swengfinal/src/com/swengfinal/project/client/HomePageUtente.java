package com.swengfinal.project.client;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.swengfinal.project.shared.Utente;

public class HomePageUtente extends Composite {

	private static HomePageUtenteUiBinder uiBinder = GWT.create(HomePageUtenteUiBinder.class);

	@UiTemplate("HomePageUtente.ui.xml")
	interface HomePageUtenteUiBinder extends UiBinder<Widget, HomePageUtente> {
	}

	public HomePageUtente() {
		initWidget(uiBinder.createAndBindUi(this));
		
		btnHome.getElement().getStyle().setMarginRight(10, Unit.PX);
		btnHome.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnHome.getElement().getStyle().setWidth(70.0, Unit.PX);
		btnIscrizione.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnIscrizione.getElement().getStyle().setWidth(90.0, Unit.PX);
		btnIscrizione.getElement().getStyle().setMarginRight(10, Unit.PX);
		btnRegistrazione.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnRegistrazione.getElement().getStyle().setWidth(90.0, Unit.PX);
		btnRegistrazione.getElement().getStyle().setMarginRight(10, Unit.PX);
		btnVoti.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnVoti.getElement().getStyle().setWidth(70.0, Unit.PX);
		btnLogout.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnLogout.getElement().getStyle().setWidth(90.0, Unit.PX);
		btnLogout.getElement().getStyle().setMarginLeft(820.0, Unit.PX);
		
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getUtente(Account.email, new AsyncCallback<Utente>() {
				public void onFailure(Throwable caught) {
					Window.alert("ERRORE!");

				}
				
				@Override
				public void onSuccess(Utente user) {
					lblNome.setText(user.getNome());
					lblCognome.setText(user.getCognome());
					lblMail.setText(user.getEmail());
				}

					
			});
		}catch(Error e){
			};
			
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
			greetingService.getCorsoStudente(Account.email, new AsyncCallback<ArrayList<String>>() {
				public void onFailure(Throwable caught) {
					Window.alert("ERRORE!");

				}
				
				@Override
				public void onSuccess(ArrayList<String> output) {
					String test = "";
					for(int i=0; i<output.size();i++) {
						test+= output.get(i) + " ";
					}
					lblCorsi.setText(test);
				}
				
			});
		}catch(Error e) {
			
		}

			
			
			
	}
	
	
		/*
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getInfoUtente(Account.email, new AsyncCallback<String>() {
				public void onFailure(Throwable caught) {
					final DialogBox dialogBox = new DialogBox();
					dialogBox.setText(caught.getMessage());
				}

				public void onSuccess(String info) {
					String [] arraySplit = info.split("\n");
					

					String htmlProfilo = "<h1>Il tuo profilo</h1>"+
							arrayInfo[0]+"<br>"+
							arrayInfo[1]+"<br>"+
							arrayInfo[2]+"<br>"+
							arrayInfo[3]+"<br>"+
							arrayInfo[4]+"<br>"+
							arrayInfo[5]+"<br>"+
							arrayInfo[6]+"<br>"+
							arrayInfo[7]+"<br>"+
							"Tipo profilo : Utente registrato";

				}
			});
		}catch(Error e){
			};
		}*/

	@UiHandler("btnHome")
	   void doClickSubmit(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new HomePageUtente());
	   }
	
	@UiHandler("btnIscrizione")
	void doClickDip(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new PageCorsiDisponibili());
	}
	
	@UiHandler("btnRegistrazione")
	void doClickContatti(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new RegistrazioneEsame());
	}
	
	@UiHandler("btnVoti")
	void doClickHome(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new PageVoti());
	}
	
	@UiHandler("btnLogout")
	void doClickLogout(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new HomePage());
	}
	
	@UiField
	Button btnIscrizione;
	
	@UiField
	Button btnHome;
	
	@UiField
	Button btnRegistrazione;
	
	@UiField
	Button btnVoti;
	
	@UiField
	Button btnLogout;
	
	@UiField
	Label lblNome;
	
	@UiField
	Label lblCognome;
	
	@UiField
	Label lblMail;
	
	@UiField
	Label lblCorsi;
	
	@UiField
	Label lblEsami;

	

}
