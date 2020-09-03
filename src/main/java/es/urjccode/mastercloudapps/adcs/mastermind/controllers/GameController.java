package es.urjccode.mastercloudapps.adcs.mastermind.controllers;

import java.util.List;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.AceptorController;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.ControllerVisitor;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.models.Session;
import es.urjccode.mastercloudapps.adcs.mastermind.models.SessionImplementation;
import es.urjccode.mastercloudapps.adcs.mastermind.types.Color;


public abstract class GameController extends AceptorController {

	GameController(Session session) {
		super(session);
	}

	public abstract int getAttempts();
	
	public abstract List<Color> getColors(int position);
	
	public abstract int getBlacks(int position);
	
	public abstract int getWhites(int position);

	public abstract boolean isWinner();

	public abstract boolean isLooser();

	public int getWidth() {
		return ((SessionImplementation)this.session).getWidth();
	}
	@Override
	public abstract void accept(ControllerVisitor controllersVisitor);

}
