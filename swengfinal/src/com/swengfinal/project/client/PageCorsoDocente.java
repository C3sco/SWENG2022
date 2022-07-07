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
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.sun.java.swing.plaf.windows.resources.windows;
import com.swengfinal.project.shared.Corso;
import com.swengfinal.project.shared.Utente;

public class PageCorsoDocente extends Composite {
	
	static int idCorso = 100;

	private static PageCorsoDocenteUiBinder uiBinder = GWT.create(PageCorsoDocenteUiBinder.class);

	@UiTemplate("PageCorsoDocente.ui.xml")
	interface PageCorsoDocenteUiBinder extends UiBinder<Widget, PageCorsoDocente> {
	}

	public PageCorsoDocente() {
		initWidget(uiBinder.createAndBindUi(this));
		
		btnHome.getElement().getStyle().setMarginRight(10, Unit.PX);
		btnHome.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnHome.getElement().getStyle().setWidth(70.0, Unit.PX);
		btnCorso.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnCorso.getElement().getStyle().setWidth(90.0, Unit.PX);
		btnCorso.getElement().getStyle().setMarginRight(10, Unit.PX);
		btnEsame.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnEsame.getElement().getStyle().setWidth(90.0, Unit.PX);
		btnEsame.getElement().getStyle().setMarginRight(10, Unit.PX);
		btnVoti.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnVoti.getElement().getStyle().setWidth(70.0, Unit.PX);
		btnLogout.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnLogout.getElement().getStyle().setWidth(90.0, Unit.PX);
		btnLogout.getElement().getStyle().setMarginLeft(800.0, Unit.PX);
		txtNomeCorso.getElement().getStyle().setMarginLeft(10.0, Unit.PX);
		txtDataFine.getElement().getStyle().setMarginLeft(30.0, Unit.PX);
		txtDescrizione.getElement().getStyle().setMarginLeft(27.0, Unit.PX);
		txtDataInizio.getElement().getStyle().setMarginLeft(15.0, Unit.PX);
		txtCoDocente.getElement().getStyle().setMarginLeft(15.0, Unit.PX);
		btnAddEsame.getElement().getStyle().setMarginLeft(35.0, Unit.PX);
		btnCreazione.getElement().getStyle().setMargin(10, Unit.PX);
		txtUpdateDataFine.getElement().getStyle().setMarginLeft(30.0, Unit.PX);
		txtUpdateDescrizione.getElement().getStyle().setMarginLeft(27.0, Unit.PX);
		txtUpdateDataInizio.getElement().getStyle().setMarginLeft(15.0, Unit.PX);
		txtUpdateCoDocente.getElement().getStyle().setMarginLeft(15.0, Unit.PX);
		btnUpdate.getElement().getStyle().setMargin(10, Unit.PX);
		btnCancellazione.getElement().getStyle().setMarginLeft(350, Unit.PX);
		menuCorsi.getElement().getStyle().setMarginLeft(50.0, Unit.PX);
		
		fillistbox();
		
		
	}
	
	
	void fillistbox()
	{
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getAllCorso(Account.email, new AsyncCallback<ArrayList<Corso>>() {
				public void onFailure(Throwable caught) {
					Alert a = new Alert("Errore prendere corso");
					System.out.println(a);


				}
				
				@Override
				public void onSuccess(ArrayList<Corso> corsi) {
					for(int i=0;i<corsi.size();i++)
					{
						menuCorsi.addItem(corsi.get(i).getNomeCorso());
					}
					

				}

					
			});
		}catch(Error e){
			};
	}
	
	@UiHandler("btnHome")
	   void doClickSubmit(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new HomePageDocente());
	   }
	
	@UiHandler("btnCorso")
	void doClickDip(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new PageCorsoDocente());
	}
	
	@UiHandler("btnEsame")
	void doClickContatti(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new PageEsameDocente());
	}
	
	@UiHandler("btnVoti")
	void doClickHome(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new PageVotiDocente());
	}
	
	@UiHandler("btnLogout")
	void doClickLogout(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new HomePage());
	}
	
	@UiHandler("btnAddEsame")
	void doClickAddEsame(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new PageEsameDocente());
	}
	
	@UiHandler("btnCreazione")
	void doClickCreazioneCorso(ClickEvent event) {

			
			ArrayList<String>dati = new ArrayList<String>();
			dati.add(0,"");
			dati.add(1, Account.email);
			dati.add(2, txtNomeCorso.getText());
			dati.add(3, txtDescrizione.getText());
			dati.add(4, txtDataInizio.getText());
			dati.add(5, txtDataFine.getText());
			dati.add(6,txtCoDocente.getText());
			
			
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
			
			greetingService.creazioneCorso(dati, new AsyncCallback<String>() {
				
				public void onFailure(Throwable c) {
					Alert a = new Alert("Errore:" + c);
					System.out.println(a);
					RootPanel.get("container").clear();
					RootPanel.get("container").add(new HomePageDocente());
				}
				
				@Override
				public void onSuccess(String result) {
					if(result.equals("Successo")) {
						RootPanel.get("container").clear();
						//Account.email = txtMail.getText();
						//Account.tipoAccount = 1;
						Alert a = new Alert("Corso creato con successo!");
						System.out.println(a);
					
						RootPanel.get("container").add(new HomePageDocente());
					}else {
						Alert a = new Alert("Errore!123");
						System.out.println(a);
					} 	
					
				}
			});
				
		}
			
			
			
			
			
	
	@UiHandler("btnCancellazione")
	void doClickDelete(ClickEvent event) {
			Window.alert("Corso eliminato");
	}
	
	@UiHandler("btnUpdate")
	void doClickUpdate(ClickEvent event) {
			Window.alert("Corso modificato");
	}
	
	
	@UiField
	Button btnCorso;
	
	@UiField
	Button btnHome;
	
	@UiField
	Button btnEsame;
	
	@UiField
	Button btnVoti;
	
	@UiField
	Button btnLogout;
	
	@UiField
	TextBox txtNomeCorso;
	
	@UiField
	TextBox txtDataInizio;
	
	@UiField
	TextBox txtDataFine;
	
	@UiField
	TextBox txtDescrizione;
	
	@UiField
	TextBox txtCoDocente;
	
	@UiField
	TextBox txtUpdateDataInizio;
	
	@UiField
	TextBox txtUpdateDataFine;
	
	@UiField
	TextBox txtUpdateDescrizione;
	
	@UiField
	TextBox txtUpdateCoDocente;
	
	@UiField
	ListBox menuCorsi;
	
	@UiField
	Button btnAddEsame;
	
	@UiField
	Button btnCreazione;
	
	@UiField
	Button btnCancellazione;
	
	@UiField
	Button btnUpdate;

}
