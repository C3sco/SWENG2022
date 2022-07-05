package com.swengfinal.project.client;

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
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.swengfinal.project.client.PageCorsiDisponibili;

public class PageVoti extends Composite {

	private static PageVotiUiBinder uiBinder = GWT.create(PageVotiUiBinder.class);

	
	@UiTemplate("PageVoti.ui.xml")
	interface PageVotiUiBinder extends UiBinder<Widget, PageVoti> {
	}

	public PageVoti() {
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
		cellTable.getElement().getStyle().setMarginLeft(450.0, Unit.PX);
		
		addTable();
	}
	
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
	
public void addTable() {
		
		TextColumn<Voto> esameColumn=new TextColumn<Voto>() {
			@Override
			public String getValue(Voto obj) {
				return obj.nomeEsame;
			}
		};
		cellTable.addColumn(esameColumn, "Esame");
		
		TextColumn<Voto> votoColumn=new TextColumn<Voto>() {
			@Override
			public String getValue(Voto obj) {
				return obj.voto;
			}
		};
		cellTable.addColumn(votoColumn, "Voto");
		
		TextColumn<Voto> cfuColumn=new TextColumn<Voto>() {
			
			public String getValue(Voto obj) {
				return obj.cfu;
			}
			
		  
		};
		
		cellTable.addColumn(cfuColumn, "Cfu");
		//cellTable.
		
		 cellTable.setRowCount(voti.size(), true);
		 
		 cellTable.setRowData(0, voti);
	     
		 
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

}
