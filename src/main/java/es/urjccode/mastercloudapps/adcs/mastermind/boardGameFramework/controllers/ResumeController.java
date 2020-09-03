package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.controllers;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.AceptorController;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.ControllerVisitor;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.models.Session;

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
