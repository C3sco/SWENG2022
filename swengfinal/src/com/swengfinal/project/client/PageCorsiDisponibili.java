package com.swengfinal.project.client;


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
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;


import java.util.Arrays;

import javax.swing.plaf.TableUI;
import javax.swing.text.TableView.TableCell;



public class PageCorsiDisponibili extends Composite{

	private static PageCorsiDisponibiliUiBinder uiBinder = GWT.create(PageCorsiDisponibiliUiBinder.class);
	
	@UiTemplate("PageCorsiDisponibili.ui.xml")
	interface PageCorsiDisponibiliUiBinder extends UiBinder<Widget, PageCorsiDisponibili> {
	}
	
	

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
		cellTable.getElement().getStyle().setMarginLeft(200.0, Unit.PX);
		txtIdCorso.getElement().getStyle().setMarginLeft(40.0, Unit.PX);
		txtNomeCorso.getElement().getStyle().setMarginLeft(17.0, Unit.PX);
	
		
		addTable();
		
	}

	
	private static class Corso{
		private final String id;
		private final String nome;
		private final String professore;
		
		public Corso(String id, String nome, String professore) {
			this.id=id;
			this.nome=nome;
			this.professore=professore;
		}
	}
	
	
	private static final java.util.List<Corso> corsi=Arrays.asList(
				new Corso("01234","Ingegneria del software", "Davide Rossi" )
			);
	
	public void addTable() {
		
		TextColumn<Corso> idColumn=new TextColumn<Corso>() {
			@Override
			public String getValue(Corso obj) {
				return obj.id;
			}
		};
		cellTable.addColumn(idColumn, "Id");
		
		TextColumn<Corso> nameColumn=new TextColumn<Corso>() {
			@Override
			public String getValue(Corso obj) {
				return obj.nome;
			}
		};
		cellTable.addColumn(nameColumn, "Nome");
		
		TextColumn<Corso> iscrizioneColumn=new TextColumn<Corso>() {
			
			public String getValue(Corso obj) {
				return obj.professore;
			}
			
		  
		};
		
		cellTable.addColumn(iscrizioneColumn, "Professore");
		//cellTable.
		
		 cellTable.setRowCount(corsi.size(), true);
		 
		 cellTable.setRowData(0, corsi);
		 
		
	     
		
		 
		 
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
			RootPanel.get("container").add(new PageVoti());
	}
	
	@UiHandler("btnLogout")
	void doClickLogout(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new HomePage());
	}
	
	@UiHandler("btnCorso")
	void doClickIscrizione(ClickEvent event) {
			RootPanel.get("container").clear();
			Window.alert("Iscrizione avvenuta");
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
	CellTable cellTable;
	
	@UiField
	TextBox txtIdCorso;
	
	@UiField
	TextBox txtNomeCorso;
	
	@UiField
	Button btnCorso;
	

}
