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

public class HomePageDocente extends Composite {

	private static HomePageDocenteUiBinder uiBinder = GWT.create(HomePageDocenteUiBinder.class);
	
	@UiTemplate("HomePageDocente.ui.xml")
	interface HomePageDocenteUiBinder extends UiBinder<Widget, HomePageDocente> {
	}

	public HomePageDocente() {
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
