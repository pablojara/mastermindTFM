package es.urjccode.mastercloudapps.adcs.mastermind.controllers;


import es.urjccode.mastercloudapps.adcs.mastermind.models.Session;
import es.urjccode.mastercloudapps.adcs.mastermind.models.StateValue;

public abstract class Controller {

	protected Session session;

	Controller(Session session) {
		this.session = session;
	}

	public void setName(String name) {
		this.session.setName(name);
	}

	public int getWidth() {
		return this.session.getWidth();
	}

	public StateValue getValueState() {
		return this.session.getValueState();
	}

	public String getName() {
		return this.session.getName();
	}

}
