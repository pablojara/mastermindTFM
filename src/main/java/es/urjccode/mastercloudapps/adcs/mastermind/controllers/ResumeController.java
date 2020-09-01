package es.urjccode.mastercloudapps.adcs.mastermind.controllers;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.AceptorController;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.ControllerVisitor;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.Session;

public abstract class ResumeController extends AceptorController {

	public ResumeController(Session session) {
		super(session);
	}

	public abstract void isNewGame(boolean newGame);

	@Override
	public void accept(ControllerVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
