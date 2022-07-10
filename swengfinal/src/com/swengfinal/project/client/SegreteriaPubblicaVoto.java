package com.swengfinal.project.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class SegreteriaPubblicaVoto extends Composite {

	private static SegreteriaPubblicaVotoUiBinder uiBinder = GWT.create(SegreteriaPubblicaVotoUiBinder.class);

	interface SegreteriaPubblicaVotoUiBinder extends UiBinder<Widget, SegreteriaPubblicaVoto> {
	}

	public SegreteriaPubblicaVoto() {
		initWidget(uiBinder.createAndBindUi(this));
		btnHomeSegreteria.getElement().getStyle().setMarginRight(10, Unit.PX);
		btnHomeSegreteria.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnHomeSegreteria.getElement().getStyle().setWidth(70.0, Unit.PX);
		btnInserisciVoto.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnInserisciVoto.getElement().getStyle().setWidth(90.0, Unit.PX);
		btnInserisciVoto.getElement().getStyle().setMarginRight(10, Unit.PX);
		btnPubblicaVoto.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnPubblicaVoto.getElement().getStyle().setWidth(90.0, Unit.PX);
		btnPubblicaVoto.getElement().getStyle().setMarginRight(10, Unit.PX);
		btnLogout.getElement().getStyle().setHeight(50.0, Unit.PX);
		btnLogout.getElement().getStyle().setWidth(90.0, Unit.PX);
		btnLogout.getElement().getStyle().setMarginLeft(870.0, Unit.PX);
	}

	@UiHandler("btnHomeSegreteria")
	void doClickHome(ClickEvent event) {
		RootPanel.get("container").clear();
		RootPanel.get("container").add(new HomePageSegreteria());
	}
		
	@UiHandler("btnInserisciVoto")
	void doClickInserisciVoto(ClickEvent event) {
		RootPanel.get("container").clear();
		RootPanel.get("container").add(new SegreteriaInserisciVoto());
	}
		
	@UiHandler("btnPubblicaVoto")
	void doClickPubblicVoto(ClickEvent event) {
		RootPanel.get("container").clear();
		RootPanel.get("container").add(new SegreteriaPubblicaVoto());
	}

	@UiHandler("btnLogout")
	void doClickLogout(ClickEvent event) {
		RootPanel.get("container").clear();
		RootPanel.get("container").add(new HomePage());
	}
	
	
	@UiField
	Button btnLogout;
	
	@UiField
	Button btnHomeSegreteria;
	
	@UiField
	Button btnInserisciVoto;
	
	@UiField
	Button btnPubblicaVoto;		
}
