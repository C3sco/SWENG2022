package com.swengfinal.project.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class HomePageUtente extends Composite {

	private static HomePageUtenteUiBinder uiBinder = GWT.create(HomePageUtenteUiBinder.class);

	@UiTemplate("HomePageUtente.ui.xml")
	interface HomePageUtenteUiBinder extends UiBinder<Widget, HomePageUtente> {
	}

	public HomePageUtente() {
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
		
	}

	@UiHandler("btnHome")
	   void doClickSubmit(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new HomePageUtente());
	   }
	
	@UiHandler("btnIscrizione")
	void doClickDip(ClickEvent event) {
			RootPanel.get("container").clear();
			//RootPanel.get("container").add(new Dipartimenti());
	}
	
	@UiHandler("btnRegistrazione")
	void doClickContatti(ClickEvent event) {
			RootPanel.get("container").clear();
			//RootPanel.get("container").add(new Contatti());
	}
	
	@UiHandler("btnVoti")
	void doClickHome(ClickEvent event) {
			RootPanel.get("container").clear();
			//RootPanel.get("container").add(new HomePage());
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
	Label lblNome;
	
	@UiField
	Label lblCognome;
	
	@UiField
	Label lblMail;
	
	@UiField
	Label lblCorsi;
	
	@UiField
	Label lblEsami;

	

}
