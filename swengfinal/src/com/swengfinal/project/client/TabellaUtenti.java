package com.swengfinal.project.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TabellaUtenti extends Composite {

	private static TabellaUtentiUiBinder uiBinder = GWT.create(TabellaUtentiUiBinder.class);

	@UiTemplate("TabellaUtenti.ui.xml")
	interface TabellaUtentiUiBinder extends UiBinder<Widget, TabellaUtenti> {
	}

	public TabellaUtenti() {
		initWidget(uiBinder.createAndBindUi(this));
		
		/*cellTableUtenti.getElement().getStyle().setFontSize(24.0, Unit.PX);
		cellTableUtenti.getElement().getStyle().setMarginTop(15.0, Unit.PX);
		cellTableUtenti.getElement().getStyle().setMarginLeft(50.0, Unit.PX);
		
		addTable();*/
	}
	
	
	/*private static final java.util.List<Utente> studenti=Arrays.asList(
				new Utente("Martin","Martin", "Martin", "Martin", "Martin", "Martin", "Martin", "Martin", "Martin" )
			);
	
	public void addTable() {
		
		TextColumn<Utente> nomeUtenteColumn=new TextColumn<Utente>() {
			@Override
			public String getValue(Utente obj) {
				return obj.getNomeUtente();
			}
		};
		cellTableUtenti.addColumn(nomeUtenteColumn, "Nome Utente");
		
		TextColumn<Utente> passwordColumn=new TextColumn<Utente>() {
			@Override
			public String getValue(Utente obj) {
				return obj.getPw();
			}
		};
		cellTableUtenti.addColumn(passwordColumn, "Password");
		
		TextColumn<Utente> emailColumn=new TextColumn<Utente>() {
			
			public String getValue(Utente obj) {
				return obj.getEmail();
			}
			
		  
		};
		cellTableUtenti.addColumn(emailColumn, "Email");
		
		TextColumn<Utente> matricolaColumn=new TextColumn<Utente>() {
			
			public String getValue(Utente obj) {
				return obj.getMatricola();
			}
			
		  
		};
		cellTableUtenti.addColumn(matricolaColumn, "Matricola");
		
		TextColumn<Utente> nomeColumn=new TextColumn<Utente>() {
			
			public String getValue(Utente obj) {
				return obj.getNome();
			}
			
		  
		};
		cellTableUtenti.addColumn(nomeColumn, "Nome");
		
		TextColumn<Utente> cognomeColumn=new TextColumn<Utente>() {
			
			public String getValue(Utente obj) {
				return obj.getCognome();
			}
			
		  
		};
		cellTableUtenti.addColumn(cognomeColumn, "Cognome");
		
		TextColumn<Utente> luogoColumn=new TextColumn<Utente>() {
			
			public String getValue(Utente obj) {
				return obj.getLuogoNascita();
			}
			
		  
		};
		cellTableUtenti.addColumn(luogoColumn, "Luogo Nascita");
		
		TextColumn<Utente> dataColumn=new TextColumn<Utente>() {
			
			public String getValue(Utente obj) {
				return obj.getDataNascita();
			}
			
		  
		};
		cellTableUtenti.addColumn(dataColumn, "Data Nascita");
		
		//cellTable.
		
		 cellTableUtenti.setRowCount(studenti.size(), true);
		 
		 cellTableUtenti.setRowData(0, studenti);
	     
		 
	}
	@UiField
	CellTable cellTableUtenti;*/

}
