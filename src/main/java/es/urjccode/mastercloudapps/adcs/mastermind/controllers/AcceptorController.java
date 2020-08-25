package es.urjccode.mastercloudapps.adcs.mastermind.controllers;


import es.urjccode.mastercloudapps.adcs.mastermind.models.Session;

public abstract class AcceptorController extends Controller {

	AcceptorController(Session session) {
		super(session);
	}

	public abstract void accept(ControllersVisitor controllersVisitor);

}
