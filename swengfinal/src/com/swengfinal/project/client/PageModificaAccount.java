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

public class PageModificaAccount extends Composite {

	private static PageModificaAccountUiBinder uiBinder = GWT.create(PageModificaAccountUiBinder.class);

	interface PageModificaAccountUiBinder extends UiBinder<Widget, PageModificaAccount> {
	}

	public PageModificaAccount() {
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
		txtPassword.getElement().getStyle().setMarginLeft(27.0, Unit.PX);
		txtEmail.getElement().getStyle().setMarginLeft(80.0, Unit.PX);
		txtNome.getElement().getStyle().setMarginLeft(15.0, Unit.PX);
		txtCognome.getElement().getStyle().setMarginLeft(58.0, Unit.PX);
		txtLuogo.getElement().getStyle().setMarginLeft(15.0, Unit.PX);
		txtData.getElement().getStyle().setMarginLeft(40.0, Unit.PX);
		btnModificaAccount.getElement().getStyle().setMargin(10.0, Unit.PX);
		btnEliminaAccount.getElement().getStyle().setMargin(10.0, Unit.PX);
		
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
	
	@UiHandler("btnModificaAccount")
	void doClickCreaAccount(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new HomePage());
	}
	
	@UiHandler("btnEliminaAccount")
	void doClickElimnaAccount(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new HomePage());
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
	Button btnModificaAccount;
	
	@UiField
	Button btnEliminaAccount;
	
	@UiField
	ListBox menuUtenti;
	
	@UiField
	TextBox txtPassword;
	
	@UiField
	TextBox txtEmail;
	
	
	
	@UiField
	TextBox txtNome;
	
	@UiField
	TextBox txtCognome;
	
	@UiField
	TextBox txtLuogo;
	
	@UiField
	TextBox txtData;
	
	

}
