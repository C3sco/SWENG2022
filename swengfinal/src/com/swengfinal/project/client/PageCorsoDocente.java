package com.swengfinal.project.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.sun.java.swing.plaf.windows.resources.windows;

public class PageCorsoDocente extends Composite {

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
		txtDataInizio.getElement().getStyle().setMarginLeft(30.0, Unit.PX);
		txtCoDocente.getElement().getStyle().setMarginLeft(15.0, Unit.PX);
		btnAddEsame.getElement().getStyle().setMarginLeft(35.0, Unit.PX);
		btnCreazione.getElement().getStyle().setMargin(10, Unit.PX);
		txtUpdateDataFine.getElement().getStyle().setMarginLeft(30.0, Unit.PX);
		txtUpdateDescrizione.getElement().getStyle().setMarginLeft(27.0, Unit.PX);
		txtUpdateDataInizio.getElement().getStyle().setMarginLeft(30.0, Unit.PX);
		txtUpdateCoDocente.getElement().getStyle().setMarginLeft(15.0, Unit.PX);
		btnUpdate.getElement().getStyle().setMargin(10, Unit.PX);
		btnCancellazione.getElement().getStyle().setMarginLeft(350, Unit.PX);
		menuCorsi.getElement().getStyle().setMarginLeft(50.0, Unit.PX);
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
			Window.alert("Corso creato");
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
