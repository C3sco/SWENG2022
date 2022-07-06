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
import com.google.gwt.user.client.ui.Widget;

public class HomePageAdmin extends Composite {

	private static HomePageAdminUiBinder uiBinder = GWT.create(HomePageAdminUiBinder.class);

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
		
		addTipologia();
		
		
	}
	
	
	@UiHandler("menuTipo")
	void changeTypeUser(ClickEvent event) {
		if(menuTipo.getSelectedValue()=="Studente") {
			RootPanel.get("infoUser").clear();
			RootPanel.get("infoUser").add(new TabellaUtenti());
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
