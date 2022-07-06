package com.swengfinal.project.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class PageCreazioneAccount extends Composite {

	private static PageCreazioneAccountUiBinder uiBinder = GWT.create(PageCreazioneAccountUiBinder.class);

	interface PageCreazioneAccountUiBinder extends UiBinder<Widget, PageCreazioneAccount> {
	}

	public PageCreazioneAccount() {
		initWidget(uiBinder.createAndBindUi(this));
		
		btnHome.getElement().getStyle().setMarginRight(10, Unit.PX);
		btnHome.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnHome.getElement().getStyle().setWidth(70.0, Unit.PX);
		btnCreazione.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnCreazione.getElement().getStyle().setWidth(90.0, Unit.PX);
		btnCreazione.getElement().getStyle().setMarginRight(10, Unit.PX);
		btnModifica.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnModifica.getElement().getStyle().setWidth(90.0, Unit.PX);
		btnModifica.getElement().getStyle().setMarginRight(10, Unit.PX);
		btnLogout.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnLogout.getElement().getStyle().setWidth(90.0, Unit.PX);
		btnLogout.getElement().getStyle().setMarginLeft(870.0, Unit.PX);
		menuTipo.getElement().getStyle().setMargin(20.0, Unit.PX);
		txtPassword.getElement().getStyle().setMarginLeft(27.0, Unit.PX);
		txtEmail.getElement().getStyle().setMarginLeft(80.0, Unit.PX);
		txtMatricola.getElement().getStyle().setMarginLeft(60.0, Unit.PX);
		txtNome.getElement().getStyle().setMarginLeft(15.0, Unit.PX);
		txtCognome.getElement().getStyle().setMarginLeft(58.0, Unit.PX);
		txtLuogo.getElement().getStyle().setMarginLeft(15.0, Unit.PX);
		txtData.getElement().getStyle().setMarginLeft(40.0, Unit.PX);
		btnCreazioneAccount.getElement().getStyle().setMargin(10.0, Unit.PX);
		addTipologia();
	}
	
	
	
	@UiHandler("btnHome")
	   void doClickSubmit(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new HomePageAdmin());
	   }
	
	@UiHandler("btnCreazione")
	void doClickDip(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new PageCreazioneAccount());
			
	}
	
	@UiHandler("btnModifica")
	void doClickContatti(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new PageModificaAccount());
	}
	
	
	@UiHandler("btnLogout")
	void doClickLogout(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new HomePage());
	}
	
	@UiHandler("btnCreazioneAccount")
	void doClickCreaAccount(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new HomePage());
	}
	
	void addTipologia(){
		menuTipo.addItem("Studente");
		menuTipo.addItem("Docente");
		menuTipo.addItem("Segreteria");
	}
	
	
	
	@UiField
	Button btnCreazione;
	
	@UiField
	Button btnHome;
	
	@UiField
	Button btnModifica;
	
	@UiField
	Button btnLogout;
	
	@UiField
	Button btnCreazioneAccount;
	
	
	@UiField
	TextBox txtPassword;
	
	@UiField
	TextBox txtEmail;
	
	@UiField
	TextBox txtMatricola;
	
	@UiField
	TextBox txtNome;
	
	@UiField
	TextBox txtCognome;
	
	@UiField
	TextBox txtLuogo;
	
	@UiField
	TextBox txtData;
	
	
	@UiField
	ListBox menuTipo;

}
