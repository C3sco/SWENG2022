package com.swengfinal.project.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Dipartimenti extends Composite {

	private static DipartimentiUiBinder uiBinder = GWT.create(DipartimentiUiBinder.class);

	interface DipartimentiUiBinder extends UiBinder<Widget, Dipartimenti> {
	}

	public Dipartimenti() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
