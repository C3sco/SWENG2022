package com.swengfinal.project.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class HomePageSegreteria extends Composite {

	private static HomePageSegreteriaUiBinder uiBinder = GWT.create(HomePageSegreteriaUiBinder.class);

	interface HomePageSegreteriaUiBinder extends UiBinder<Widget, HomePageSegreteria> {
	}

	public HomePageSegreteria() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
