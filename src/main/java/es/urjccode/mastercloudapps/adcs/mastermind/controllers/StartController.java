package es.urjccode.mastercloudapps.adcs.mastermind.controllers;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.ControllerVisitor;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.models.Session;
import es.urjccode.mastercloudapps.adcs.mastermind.controllers.GameController;

public abstract class StartController extends GameController {

	public StartController(Session session) {
		super(session);
	}

	public abstract void start();

	public abstract void start(String title);

	public abstract String[] getGamesNames();

	@Override
	public void accept(ControllerVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
