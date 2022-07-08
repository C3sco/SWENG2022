package com.swengfinal.project.client;

import java.util.ArrayList;

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
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.swengfinal.project.shared.Docente;
import com.swengfinal.project.shared.Utente;

public class HomePageAdmin extends Composite {

	private static HomePageAdminUiBinder uiBinder = GWT.create(HomePageAdminUiBinder.class);

	final ArrayList<Utente> listaStudenti = new ArrayList<Utente>();
	final ArrayList<Docente> listaDocenti = new ArrayList<Docente>();

	@UiTemplate("HomePageAdmin.ui.xml")
	interface HomePageAdminUiBinder extends UiBinder<Widget, HomePageAdmin> {
	}

	public HomePageAdmin() {
		initWidget(uiBinder.createAndBindUi(this));
		
		btnHomeAdmin.getElement().getStyle().setMarginRight(10, Unit.PX);
		btnHomeAdmin.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnHomeAdmin.getElement().getStyle().setWidth(70.0, Unit.PX);
		btnCreazioneAdmin.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnCreazioneAdmin.getElement().getStyle().setWidth(90.0, Unit.PX);
		btnCreazioneAdmin.getElement().getStyle().setMarginRight(10, Unit.PX);
		btnModificaAdmin.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnModificaAdmin.getElement().getStyle().setWidth(90.0, Unit.PX);
		btnModificaAdmin.getElement().getStyle().setMarginRight(10, Unit.PX);
		btnLogout.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnLogout.getElement().getStyle().setWidth(90.0, Unit.PX);
		btnLogout.getElement().getStyle().setMarginLeft(870.0, Unit.PX);
		menuTipo.getElement().getStyle().setMargin(20.0, Unit.PX);

		cellTable.getElement().getStyle().setFontSize(24.0, Unit.PX);
		cellTable.getElement().getStyle().setMarginTop(35.0, Unit.PX);

		getStudenti();

		
		addTipologia();
		
		
	}
	
	public void getStudenti() {
		final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

		greetingService.getStudenti(new AsyncCallback<ArrayList<Utente>>() {
			public void onFailure(Throwable caught) {
				Alert a = new Alert("Errore stampa utente");
				System.out.println(a);
			}
			@Override
			public void onSuccess(ArrayList<Utente> output) {
				for(int i=0;i<output.size();i++) {
					listaStudenti.add(output.get(i));
				}
			}	
		});
	}
	
	

	
	public void newTableStudente() {

		cellTable.setRowCount(listaStudenti.size(), true);
		 
		cellTable.setRowData(0, listaStudenti);

		
		TextColumn<Utente> emailColumn=new TextColumn<Utente>() {
			@Override
			public String getValue(Utente obj) {
				return obj.getEmail();
			}
		};
		cellTable.addColumn(emailColumn, "Email");
		/*
		TextColumn<Utente> matricolaColumn=new TextColumn<Utente>() {
			
			public String getValue(Utente obj) {
				return obj.getMatricola();
			}
		};
		
		cellTable.addColumn(matricolaColumn, "Matricola");*/
		
		TextColumn<Utente> nomeColumn=new TextColumn<Utente>() {
			@Override
			public String getValue(Utente obj) {
				return obj.getCognome();
			}
		};
		cellTable.addColumn(nomeColumn, "Nome");
		
		TextColumn<Utente> cognomeColumn=new TextColumn<Utente>() {
			@Override
			public String getValue(Utente obj) {
				return obj.getNome();
			}
		};
		cellTable.addColumn(cognomeColumn, "Cognome");
		
		TextColumn<Utente> luogoColumn=new TextColumn<Utente>() {
			@Override
			public String getValue(Utente obj) {
				return obj.getNome();
			}
		};
		cellTable.addColumn(luogoColumn, "Luogo di Nascita");
		
		TextColumn<Utente> dataColumn=new TextColumn<Utente>() {
			@Override
			public String getValue(Utente obj) {
				return obj.getCognome();
			}
		};
		cellTable.addColumn(dataColumn, "Data di Nascita");
	}
	
	
public void newTableDocente() {
		
		
		TextColumn<Docente> emailColumn=new TextColumn<Docente>() {
			
			public String getValue(Docente obj) {
				return obj.getEmail();
			}
			
		  
		};
		cellTableDocenti.addColumn(emailColumn, "Email");
		
		
		TextColumn<Docente> nomeColumn=new TextColumn<Docente>() {
			
			public String getValue(Docente obj) {
				return obj.getNome();
			}
			
		  
		};
		cellTableDocenti.addColumn(nomeColumn, "Nome");
		
		TextColumn<Docente> cognomeColumn=new TextColumn<Docente>() {
			
			public String getValue(Docente obj) {
				return obj.getCognome();
			}
			
		  
		};
		cellTableDocenti.addColumn(cognomeColumn, "Cognome");
		
		TextColumn<Docente> luogoColumn=new TextColumn<Docente>() {
			
			public String getValue(Docente obj) {
				return obj.getLuogoNascita();
			}
			
		  
		};
		cellTableDocenti.addColumn(luogoColumn, "Luogo Nascita");
		
		TextColumn<Docente> dataColumn=new TextColumn<Docente>() {
			
			public String getValue(Docente obj) {
				return obj.getDataNascita();
			}
			
		  
		};
		cellTableDocenti.addColumn(dataColumn, "Data Nascita");
		
		//cellTable.
		
		 cellTableDocenti.setRowCount(listaDocenti.size(), true);
		 
		 cellTableDocenti.setRowData(0, listaDocenti);
}
	//metodo changeTypeUser mi switcha le table
// quando entro popolo le tables in automatico
	

	@UiHandler("menuTipo")
	void changeTypeUser(ClickEvent event) {
		if(menuTipo.getSelectedValue()=="Studente") {
			RootPanel.get("infoUser").clear();

			RootPanel.get("infoUser").add(new TabellaUtenti());

			newTableStudente();
			
			//RootPanel.get("infoUser").add(new TabellaUtenti());
			
			
			

		}else if(menuTipo.getSelectedValue()=="Docente") {
			RootPanel.get("infoUser").clear();
			RootPanel.get("infoUser").add(new TabellaDocenti());
		}
	}
	
	@UiHandler("btnHomeAdmin")
	   void doClickSubmit(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new HomePageAdmin());
	   }
	
	@UiHandler("btnCreazioneAdmin")
	void doClickDip(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new PageCreazioneAccount());
			
	}
	
	@UiHandler("btnModificaAdmin")
	void doClickContatti(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new PageModificaAccount());
	}
	
	
	@UiHandler("btnLogout")
	void doClickLogout(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new HomePage());
	}
	
	void addTipologia(){
		menuTipo.addItem("Studente");
		menuTipo.addItem("Docente");
	}

	@UiField
	CellTable<Docente> cellTableDocenti;
	
	@UiField
	CellTable<Utente> cellTable;

	
	@UiField
	Button btnCreazioneAdmin;
	
	@UiField
	Button btnHomeAdmin;
	
	@UiField
	Button btnModificaAdmin;
	
	@UiField
	Button btnLogout;
	
	@UiField
	ListBox menuTipo;

}
