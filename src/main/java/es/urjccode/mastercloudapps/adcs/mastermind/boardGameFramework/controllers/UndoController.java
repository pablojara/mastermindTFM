package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.controllers;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.controllers.Controller;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.models.Session;
import es.urjccode.mastercloudapps.adcs.mastermind.models.SessionImplementation;

public class UndoController extends Controller {

	public UndoController(Session session) {
		super(session);
	}

	public void undo() {
		((SessionImplementation) this.session).undo();
	}

	public boolean undoable() {
		return ((SessionImplementation) this.session).undoable();
	}

}
