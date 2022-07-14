package com.swengfinal.project.client;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.swengfinal.project.shared.Studente;
import com.swengfinal.project.shared.Voto;

public class SegreteriaInserisciVoto extends Composite {

	private static SegreteriaInserisciVotoUiBinder uiBinder = GWT.create(SegreteriaInserisciVotoUiBinder.class);

	interface SegreteriaInserisciVotoUiBinder extends UiBinder<Widget, SegreteriaInserisciVoto> {
	}
	
	private static ArrayList<Voto> listaVoti = new ArrayList<Voto>();
	
	private static final ArrayList<Studente> listaStudenti = new ArrayList<Studente>();

	public SegreteriaInserisciVoto() {
		initWidget(uiBinder.createAndBindUi(this));
		
		getStudenti();
		
		getVoti();
		
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
	
	
	
	public void getStudenti() {
		final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

		greetingService.getStudenti(new AsyncCallback<ArrayList<Studente>>() {
			public void onFailure(Throwable caught) {
				Alert a = new Alert("Errore getStudenti");
				System.out.println(a);
			}
			@Override
			public void onSuccess(ArrayList<Studente> output) {
				listaStudenti.clear();
				for(int i=0;i<output.size();i++) {					
					listaStudenti.add(output.get(i));
					

				}
			}	
		});
	}
	
	public void getVoti() {
		final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

		greetingService.getVotoAll(new AsyncCallback<ArrayList<Voto>>() {
			public void onFailure(Throwable caught) {
				Alert a = new Alert("Errore getStudenti");
				System.out.println(a);
			}
			@Override
			public void onSuccess(ArrayList<Voto> output) {
				listaVoti.clear();
				for(int i=0;i<output.size();i++) {					
					listaVoti.add(output.get(i));
					

				}
			}	
		});
	}

	
	@UiHandler("btnHomeSegreteria")
	void doClickHome(ClickEvent event) {
		RootPanel.get("container").clear();
		RootPanel.get("container").add(new HomePageSegreteria(listaStudenti));
	}
		
	@UiHandler("btnInserisciVoto")
	void doClickInserisciVoto(ClickEvent event) {
		RootPanel.get("container").clear();
		RootPanel.get("container").add(new SegreteriaInserisciVoto());
	}
		
	@UiHandler("btnPubblicaVoto")
	void doClickPubblicVoto(ClickEvent event) {
		RootPanel.get("container").clear();
		RootPanel.get("container").add(new SegreteriaPubblicaVoto(listaVoti));
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
