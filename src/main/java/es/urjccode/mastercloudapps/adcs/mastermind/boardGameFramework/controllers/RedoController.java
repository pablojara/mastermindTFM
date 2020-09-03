package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.controllers;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.controllers.Controller;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.models.Session;
import es.urjccode.mastercloudapps.adcs.mastermind.models.SessionImplementation;

public class RedoController extends Controller {

	public RedoController(Session session) {
		super(session);
	}

	public void redo() {
		((SessionImplementation) this.session).redo();
	}

	public boolean redoable() {
		return ((SessionImplementation) this.session).redoable();
	}

}
