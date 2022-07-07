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
import com.swengfinal.project.shared.Corso;

public class PageEsameDocente extends Composite {

	private static PageEsameDocenteUiBinder uiBinder = GWT.create(PageEsameDocenteUiBinder.class);

	@UiTemplate("PageEsameDocente.ui.xml")
	interface PageEsameDocenteUiBinder extends UiBinder<Widget, PageEsameDocente> {
	}

	public PageEsameDocente() {
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
		txtData.getElement().getStyle().setMarginLeft(30.0, Unit.PX);
		txtCfu.getElement().getStyle().setMarginLeft(40.0, Unit.PX);
		txtAula.getElement().getStyle().setMarginLeft(30.0, Unit.PX);
		txtOra.getElement().getStyle().setMarginLeft(36.0, Unit.PX);
		btnCreazione.getElement().getStyle().setMargin(10, Unit.PX);
		menuUpdateCorsi.getElement().getStyle().setMarginLeft(28.0, Unit.PX);
		txtUpdateData.getElement().getStyle().setMarginLeft(36.0, Unit.PX);
		txtUpdateCfu.getElement().getStyle().setMarginLeft(15.0, Unit.PX);
		txtUpdateAula.getElement().getStyle().setMarginLeft(36.0, Unit.PX);
		txtUpdateOra.getElement().getStyle().setMarginLeft(15.0, Unit.PX);
		btnUpdate.getElement().getStyle().setMargin(10, Unit.PX);
		btnCancellazione.getElement().getStyle().setMarginLeft(350, Unit.PX);
		menuCorsi.getElement().getStyle().setMarginLeft(28.0, Unit.PX);
		
		
		fillistbox();
	}
	
	void fillistbox()
	{
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getAllCorso(Account.email, new AsyncCallback<ArrayList<Corso>>() {
				public void onFailure(Throwable caught) {
					Window.alert("ERRORE!");

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
	
	@UiHandler("btnCreazione")
	void doClickCreazioneCorso(ClickEvent event) {
		ArrayList<String>dati = new ArrayList<String>();
		dati.add(0, "");
		dati.add(1, "");
		dati.add(2, txtData.getText());
		dati.add(3, txtOra.getText());
		dati.add(4, txtAula.getText());
		dati.add(5, txtCfu.getText());
		dati.add(6,  menuCorsi.getSelectedValue());
		dati.add(7, Account.email);
		
		final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
		
		greetingService.creazioneEsame(dati, idCorso, new AsyncCallback<String>() {
				
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
			Window.alert("Esame eliminato");
	}
	
	@UiHandler("btnUpdate")
	void doClickUpdate(ClickEvent event) {
			Window.alert("Esame modificato");
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
	TextBox txtData;
	
	@UiField
	TextBox txtCfu;
	
	@UiField
	TextBox txtAula;
	
	@UiField
	TextBox txtOra;
	
	@UiField
	TextBox txtUpdateData;
	
	@UiField
	TextBox txtUpdateCfu;
	
	@UiField
	TextBox txtUpdateAula;
	
	@UiField
	TextBox txtUpdateOra;
	
	@UiField
	ListBox menuCorsi;
	
	
	
	@UiField
	ListBox menuUpdateCorsi;
	
	@UiField
	Button btnCreazione;
	
	@UiField
	Button btnCancellazione;
	
	@UiField
	Button btnUpdate;

}
