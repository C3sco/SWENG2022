package com.swengfinal.project.client;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.swengfinal.project.shared.Corso;
import com.swengfinal.project.shared.Esame;

public class RegistrazioneEsame extends Composite {

	private static RegistrazioneEsameUiBinder uiBinder = GWT.create(RegistrazioneEsameUiBinder.class);

	@UiTemplate("RegistrazioneEsame.ui.xml")
	interface RegistrazioneEsameUiBinder extends UiBinder<Widget, RegistrazioneEsame> {
	}
	
	private static final ArrayList<Integer> corsiStudenti = new ArrayList<Integer>();
	
	private static final ArrayList<Esame> esamiStudenti = new ArrayList<Esame>();

	public RegistrazioneEsame() {
		initWidget(uiBinder.createAndBindUi(this));
		
		menuCorsi.clear();
		
		getCorsiStudente();
		addOptionMenuEsami();
		
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
			
		
	}

	
	/* Ritorna tutti i corsi disponibili per l'utente */
	public void getCorsiStudente() {
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getCorsoStudente(Account.email,new AsyncCallback<ArrayList<Integer>>() {
				public void onFailure(Throwable caught) {
					Window.alert("ERRORE!");

				}
				@Override
				public void onSuccess(ArrayList<Integer> corsi) {
					
					for(int i=0;i<corsi.size();i++) {
						corsiStudenti.add(corsi.get(i));
					}
				}
			});
		}catch(Error e){
			};
	}
	
	public void addOptionMenuEsami() {
		
		
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getEsami(new AsyncCallback<ArrayList<Esame>>() {
				public void onFailure(Throwable caught) {
					Window.alert("ERRORE!");

				}
				@Override
				public void onSuccess(ArrayList<Esame> esami) {
					
					for(int i=0;i<esami.size();i++) {
						esamiStudenti.add(esami.get(i));
						for(int a=0; a<corsiStudenti.size(); a++) {
							if(esami.get(i).getIdCorso() == corsiStudenti.get(a)) {
								menuCorsi.addItem(esami.get(i).getNomeEsame());
							}
						}
					}
				}
			});
		}catch(Error e){
			};
	}
	
	@UiHandler("btnHome")
	   void doClickSubmit(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new HomePageUtente());
	   }
	
	@UiHandler("btnIscrizione")
	void doClickIscrizioneEsame(ClickEvent event) {
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
	
	@UiHandler("btnEsame")
	void doClickEsame(ClickEvent event) {
		final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
		Integer id = 0;
		String nomeCorso = menuCorsi.getSelectedValue();
		for(int i=0;i<esamiStudenti.size();i++) {
			if(esamiStudenti.get(i).getNomeEsame().equals(nomeCorso)) {
				id = esamiStudenti.get(i).getIdEsame();
			}
		}
		/*Alert nice = new Alert("Id:" + id + txtNomeCorso.getSelectedValue());
		System.out.println(nice);*/
		greetingService.iscrizioneEsame(Account.email, id , new AsyncCallback<String>() {
			public void onFailure(Throwable caught) {

			}
			@Override
			public void onSuccess(String result) {
				if(result=="Successo") {
					Alert nice = new Alert("Successo!");
					System.out.println(nice);
				}else if(result=="Errore") {
					Alert e = new Alert("Sei gia iscritto a questo esame!");
					System.out.println(e);
				}
			}
	
		});
		RootPanel.get("container").clear();
		RootPanel.get("container").add(new RegistrazioneEsame());
	}
	
	@UiHandler("menuCorsi")
	void doClickCorsi(ClickEvent event) {
		final String voce=menuCorsi.getSelectedValue();
		
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getEsami(new AsyncCallback<ArrayList<Esame>>() {
				public void onFailure(Throwable caught) {
					Window.alert("ERRORE!");

				}
				@Override
				public void onSuccess(ArrayList<Esame> esami) {
					
					for(int i=0;i<esami.size();i++) {
						for(int a=0; a<corsiStudenti.size(); a++) {
							if(esami.get(i).getIdCorso() == corsiStudenti.get(a)) {
								if(esami.get(i).getNomeEsame().equals(voce)) {
									dataAppello.setText(esami.get(i).getData());
								}
							}
						}
					}
				}
			});
		}catch(Error e){
			};
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
	Button btnEsame;
	
	@UiField
	ListBox menuCorsi;
	
	@UiField
	Label dataAppello;
	
	
	
}
