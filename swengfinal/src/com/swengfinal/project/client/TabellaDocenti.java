package com.swengfinal.project.client;

import java.util.Arrays;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.swengfinal.project.shared.Utente;

public class TabellaDocenti extends Composite {

	private static TabellaDocentiUiBinder uiBinder = GWT.create(TabellaDocentiUiBinder.class);

	@UiTemplate("TabellaDocenti.ui.xml")
	interface TabellaDocentiUiBinder extends UiBinder<Widget, TabellaDocenti> {
	}

	public TabellaDocenti() {
		initWidget(uiBinder.createAndBindUi(this));
		
		/*cellTableDocenti.getElement().getStyle().setFontSize(24.0, Unit.PX);
		cellTableDocenti.getElement().getStyle().setMarginTop(15.0, Unit.PX);
		cellTableDocenti.getElement().getStyle().setMarginLeft(70.0, Unit.PX);
		
		addTable();*/
	}
	
	/*private static final java.util.List<Utente> docenti=Arrays.asList(
			new Utente("Martin","Martin", "Martin", "Martin", "Martin", "Martin", "Martin", "Martin", "Martin" )
		);

	public void addTable() {
		
		TextColumn<Utente> nomeUtenteColumn=new TextColumn<Utente>() {
			@Override
			public String getValue(Utente obj) {
				return obj.getNomeUtente();
			}
		};
		cellTableDocenti.addColumn(nomeUtenteColumn, "Nome Utente");
		
		TextColumn<Utente> passwordColumn=new TextColumn<Utente>() {
			@Override
			public String getValue(Utente obj) {
				return obj.getPw();
			}
		};
		cellTableDocenti.addColumn(passwordColumn, "Password");
		
		TextColumn<Utente> emailColumn=new TextColumn<Utente>() {
			
			public String getValue(Utente obj) {
				return obj.getEmail();
			}
			
		  
		};
		cellTableDocenti.addColumn(emailColumn, "Email");
		
		
		TextColumn<Utente> nomeColumn=new TextColumn<Utente>() {
			
			public String getValue(Utente obj) {
				return obj.getNome();
			}
			
		  
		};
		cellTableDocenti.addColumn(nomeColumn, "Nome");
		
		TextColumn<Utente> cognomeColumn=new TextColumn<Utente>() {
			
			public String getValue(Utente obj) {
				return obj.getCognome();
			}
			
		  
		};
		cellTableDocenti.addColumn(cognomeColumn, "Cognome");
		
		TextColumn<Utente> luogoColumn=new TextColumn<Utente>() {
			
			public String getValue(Utente obj) {
				return obj.getLuogoNascita();
			}
			
		  
		};
		cellTableDocenti.addColumn(luogoColumn, "Luogo Nascita");
		
		TextColumn<Utente> dataColumn=new TextColumn<Utente>() {
			
			public String getValue(Utente obj) {
				return obj.getDataNascita();
			}
			
		  
		};
		cellTableDocenti.addColumn(dataColumn, "Data Nascita");
		
		//cellTable.
		
		 cellTableDocenti.setRowCount(docenti.size(), true);
		 
		 cellTableDocenti.setRowData(0, docenti);
	     
		 
		}
		@UiField
		CellTable cellTableDocenti;*/
	
	}
