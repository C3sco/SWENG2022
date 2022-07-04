package com.swengfinal.project.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class RegistrazioneEsame extends Composite {

	private static RegistrazioneEsameUiBinder uiBinder = GWT.create(RegistrazioneEsameUiBinder.class);

	@UiTemplate("RegistrazioneEsame.ui.xml")
	interface RegistrazioneEsameUiBinder extends UiBinder<Widget, RegistrazioneEsame> {
	}

	public RegistrazioneEsame() {
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
			
		addOptionCorsi();
		addOptionAppelli();
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
	
	@UiHandler("btnEsame")
	void doClickEsame(ClickEvent event) {
			RootPanel.get("container").clear();
			Window.alert("Iscrizione avvenuta");
	}
	
	void addOptionCorsi() {
		
		menuCorsi.addItem("Ingeneria del software", new Command() {
	         @Override
	         public void execute() {
	            showSelectedMenuItem("Ingeneria del software");
	         }
	      });
		
		
		
		menuCorsi.addItem("Ingeneria del software", new Command() {
	         @Override
	         public void execute() {
	            showSelectedMenuItem("Ingeneria del software");
	         }
	      });
		
		
	}
	
	void addOptionAppelli() {
		menuAppelli.addItem("Appello del "+"21/03/2022", new Command() {
	         @Override
	         public void execute() {
	            showSelectedMenuItem("Appello del "+"21/03/2022");
	         }
	      });
	}
	
	void showSelectedMenuItem(String menuItemName){
	      Window.alert("Menu item: "+menuItemName+" selected");
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
	Button btnEsame;
	
	@UiField
	MenuBar menuCorsi;
	
	@UiField
	MenuBar menuAppelli;
	
	
	
}
