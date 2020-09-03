package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.controllers;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.controllers.Controller;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.models.Session;
import es.urjccode.mastercloudapps.adcs.mastermind.models.SessionImplementation;

public class ExitController extends Controller {

	public ExitController(Session session) {
		super(session);
	}

	public void next() {
		(this.session).next();
	}

}
