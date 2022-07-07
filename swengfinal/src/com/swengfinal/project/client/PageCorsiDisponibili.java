package com.swengfinal.project.client;


import com.gargoylesoftware.htmlunit.javascript.host.Console;
import com.google.gwt.canvas.dom.client.Context;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.NativeEvent;
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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.swengfinal.project.shared.Corso;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.plaf.TableUI;
import javax.swing.text.TableView.TableCell;



public class PageCorsiDisponibili extends Composite{
	private static final ArrayList<Corso> corsiFinal = new ArrayList<Corso>();
	private static PageCorsiDisponibiliUiBinder uiBinder = GWT.create(PageCorsiDisponibiliUiBinder.class);
	
	@UiTemplate("PageCorsiDisponibili.ui.xml")
	interface PageCorsiDisponibiliUiBinder extends UiBinder<Widget, PageCorsiDisponibili> {
	}
	
	
	static int i = 0;
	public PageCorsiDisponibili() {
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
		cellTable.getElement().getStyle().setFontSize(24.0, Unit.PX);
		cellTable.getElement().getStyle().setMarginTop(35.0, Unit.PX);
		//cellTable.getElement().getStyle().setMarginLeft(200.0, Unit.PX);
		//txtIdCorso.getElement().getStyle().setMarginLeft(40.0, Unit.PX);
		//txtNomeCorso.getElement().getStyle().setMarginLeft(17.0, Unit.PX);
		

		getCorsi();

		newTable();
		
		


	
	}
	
	/* Ritorna tutti i corsi disponibili per l'utente */
	public void getCorsi() {
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getCorsi(new AsyncCallback<ArrayList<Corso>>() {
				public void onFailure(Throwable caught) {
					Window.alert("ERRORE!");

				}
				@Override
				public void onSuccess(ArrayList<Corso> corsi) {
					
					for(int i=0;i<corsi.size();i++) {
						corsiFinal.add(corsi.get(i));
						txtNomeCorso.addItem(corsi.get(i).getNomeCorso());	
					}
				}
		
			});
		}catch(Error e){
			};
	}
	
	public void newTable() {

		cellTable.setRowCount(corsiFinal.size(), true);
		 
		cellTable.setRowData(0, corsiFinal);

		TextColumn<Corso> idColumn=new TextColumn<Corso>() {
			@Override
			public String getValue(Corso obj) {
				String tmp = obj.toString();
				return (tmp);
			}
		};
		cellTable.addColumn(idColumn, "Id");
		
		TextColumn<Corso> nameColumn=new TextColumn<Corso>() {
			@Override
			public String getValue(Corso obj) {
				return obj.getNomeCorso();
			}
		};
		cellTable.addColumn(nameColumn, "Nome");
		
		TextColumn<Corso> iscrizioneColumn=new TextColumn<Corso>() {
			
			public String getValue(Corso obj) {
				return obj.getEmailDocente();
			}
		};
		
		cellTable.addColumn(iscrizioneColumn, "Professore");
		
		
		 
		
	     
		TextColumn<Corso> dataInizioColumn=new TextColumn<Corso>() {
			@Override
			public String getValue(Corso obj) {
				return obj.getDataInizio();
			}
		};
		cellTable.addColumn(dataInizioColumn, "Data Inizio");
		
		TextColumn<Corso> dataFineColumn=new TextColumn<Corso>() {
			@Override
			public String getValue(Corso obj) {
				return obj.getDataFine();
			}
		};
		cellTable.addColumn(dataFineColumn, "Data Fine");
		
		
		 
	}


	@UiHandler("btnHome")
	   void doClickSubmit(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new HomePageUtente());
	   }


	@UiHandler("btnIscrizione")
	void doClickDip(ClickEvent event) {
		
			
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
	
	@UiHandler("btnCorso")
	void doClickIscrizione(ClickEvent event) {
		final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
		int id = 0;
		String nomeCorso = txtNomeCorso.getSelectedValue();
		for(int i=0;i<corsiFinal.size();i++) {
			if(corsiFinal.get(i).getNomeCorso()==nomeCorso) {
				id = corsiFinal.get(i).getIdCorso();
			}
		}
		greetingService.iscrizioneCorso(Account.email, id , new AsyncCallback<String>() {
			public void onFailure(Throwable caught) {

			}
			@Override
			public void onSuccess(String result) {
				if(result=="Successo") {
					Alert nice = new Alert("Successo!");
					System.out.println(nice);
				}
			}
	
		});
		RootPanel.get("container").clear();
		RootPanel.get("container").add(new HomePageUtente());
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
	CellTable<Corso> cellTable;
	
	
	@UiField
	ListBox txtNomeCorso;
	
	@UiField
	Button btnCorso;
	

}
