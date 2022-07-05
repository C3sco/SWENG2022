package com.swengfinal.project.client;


import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.swengfinal.project.shared.Utente;

public class Login extends Composite {

	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

	@UiTemplate("Login.ui.xml")
	interface LoginUiBinder extends UiBinder<Widget, Login> {
		
		
	}

	public Login() {
		initWidget(uiBinder.createAndBindUi(this));
		
		btnHome.getElement().getStyle().setMarginRight(10, Unit.PX);
		btnHome.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnHome.getElement().getStyle().setWidth(70.0, Unit.PX);
		btnDip.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnDip.getElement().getStyle().setWidth(90.0, Unit.PX);
		btnDip.getElement().getStyle().setMarginRight(10, Unit.PX);
		btnContatti.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnContatti.getElement().getStyle().setWidth(90.0, Unit.PX);
		btnContatti.getElement().getStyle().setMarginRight(10, Unit.PX);
		btnLogin.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnLogin.getElement().getStyle().setWidth(70.0, Unit.PX);
		txtMail.getElement().getStyle().setMarginLeft(10.0, Unit.PX);
		txtPassword.getElement().getStyle().setMarginLeft(35.0, Unit.PX);
		btnSubmit.getElement().getStyle().setHeight(40.0, Unit.PX);
		btnSubmit.getElement().getStyle().setWidth(70.0, Unit.PX);
		btnRegistrazione.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnRegistrazione.getElement().getStyle().setWidth(90.0, Unit.PX);
		btnRegistrazione.getElement().getStyle().setMarginLeft(10.0, Unit.PX);
	}
		
	//final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
		
	@UiHandler("btnLogin")
	   void doClickSubmit(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new Login());
	   }
	
	@UiHandler("btnDip")
	void doClickDip(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new Dipartimenti());
	}
	
	@UiHandler("btnContatti")
	void doClickContatti(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new Contatti());
	}
	
	@UiHandler("btnHome")
	void doClickHome(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new HomePage());
	}
	@UiHandler("btnRegistrazione")
	   void doClickRegistrazione(ClickEvent event) {
			RootPanel.get("container").clear();
			RootPanel.get("container").add(new Registrazione());
	   }
	
	@UiHandler("btnSubmit")
	void doClickLogin(ClickEvent event) {
		final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
		//Window.alert(txtPassword.getText() + " " + txtMail.getText());
		greetingService.login(txtMail.getText(), txtPassword.getText(), new AsyncCallback<Utente>() {
			
			
			
			public void onFailure(Throwable c) {

				RootPanel.get("container").clear();
				RootPanel.get("container").add(new HomePage());
			}
			
			@Override
			public void onSuccess(Utente user) {
			Account.email = txtMail.getText();
			//Account.tipoAccount = user.getTipologia();
			
		/*
			Alert alert13 = new Alert("INT: " + result);
			System.out.print(alert13);*/
			
			RootPanel.get("container").clear();
			if(user.getTipologia()=="Studente") {
				RootPanel.get("container").add(new HomePageUtente());
			}else if(user.getTipologia()=="Docente") {
				RootPanel.get("container").add(new HomePageDocente());
			}
			
			else {
				RootPanel.get("container").add(new HomePage());
			}
/*
			switch(result) {
			
			case 0:
				Alert alert = new Alert("Errore!");
				System.out.print(alert);
				RootPanel.get("container").add(new HomePage());
				break;
			case 1:
				RootPanel.get("container").add(new HomePageUtente());
				break;
			case 2: //admin
				break;
			case 3:  //segreteria
				break;
			case 4:  //docente
				RootPanel.get("container").add(new HomePageDocente());
				break;
			case 5:	 //errore password
				Alert alert3 = new Alert("case 5, errore di password!");
				System.out.print(alert3);
				RootPanel.get("container").add(new HomePage());
				break;
			case 6:  //errore mail
				Alert alert4 = new Alert("case 6, errore di email");
				System.out.print(alert4);
				RootPanel.get("container").add(new HomePage());
				break;
			default:
				Alert alert2 = new Alert("ERRORE");
				System.out.print(alert2);
				RootPanel.get("container").add(new HomePage());
				break;
				
			}*/
			
			}
		});
		
			
		
	}
	
	@UiField
	Button btnLogin;
	
	@UiField
	Button btnHome;
	
	@UiField
	Button btnDip;
	
	@UiField
	Button btnContatti;
	
	@UiField
	Button btnRegistrazione;
	
	@UiField
	TextBox txtMail;
	
	@UiField
	TextBox txtPassword;
	
	@UiField
	Button btnSubmit;
}
