package com.swengfinal.project.client;

import java.util.ArrayList;
import java.util.Arrays;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.swengfinal.project.client.PageCorsiDisponibili;
import com.swengfinal.project.shared.Corso;
import com.swengfinal.project.shared.Voto;
import com.swengfinal.project.shared.Studente;
import com.swengfinal.project.shared.Utente;


public class PageVoti extends Composite {

	private static PageVotiUiBinder uiBinder = GWT.create(PageVotiUiBinder.class);
	private static  ArrayList<Voto> votiFinal = new ArrayList<Voto>();
	public static Studente studente = new Studente();
	
	@UiTemplate("PageVoti.ui.xml")
	interface PageVotiUiBinder extends UiBinder<Widget, PageVoti> {
	}

	public PageVoti(ArrayList<Voto> list) {
		
		initWidget(uiBinder.createAndBindUi(this));
		
		getUtente();
		
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
		cellTable.getElement().getStyle().setFontSize(24.0, Unit.PX);
		cellTable.getElement().getStyle().setMarginTop(35.0, Unit.PX);
		cellTable.getElement().getStyle().setMarginLeft(450.0, Unit.PX);
		
		votiFinal=list;
		
		addTable();
	}
	
	
	
	public void getUtente() {
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getUtente(Account.email, new AsyncCallback<Utente>() {
				public void onFailure(Throwable caught) {
					Window.alert("ERRORE!");
				}
				@Override
				public void onSuccess(Utente user) {
					studente = (Studente) user;
				}		
			});
		}catch(Error e){
			};
	}
	/*
	private static class Voto{
		private final String nomeEsame;
		private final String voto;
		private final String cfu;
		
		public Voto(String nomeEsame, String voto, String cfu) {
			this.nomeEsame=nomeEsame;
			this.voto=voto;
			this.cfu=cfu;
		}
	}
	
	
	private static final java.util.List<Voto> voti=Arrays.asList(
				new Voto("Ingegneria del software","30", "6" )
			);
	*/
public void addTable() {
		
		TextColumn<Voto> esameColumn=new TextColumn<Voto>() {
			@Override
			public String getValue(Voto obj) {
				return obj.getNomeEsame();
			}
		};
		cellTable.addColumn(esameColumn, "Esame");
		
		TextColumn<Voto> votoColumn=new TextColumn<Voto>() {
			@Override
			public String getValue(Voto obj) {
				return obj.getVoto();
			}
		};
		cellTable.addColumn(votoColumn, "Voto");
		
		
		//cellTable.
		
		 cellTable.setRowCount(votiFinal.size(), true);
		 
		 cellTable.setRowData(0, votiFinal);
	     
		 
	}
	
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
			RootPanel.get("container").add(new PageVoti(votiFinal));
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
	CellTable<Voto> cellTable;

}
