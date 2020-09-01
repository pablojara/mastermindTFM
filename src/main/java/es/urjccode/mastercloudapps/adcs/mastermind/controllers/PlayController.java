package es.urjccode.mastercloudapps.adcs.mastermind.controllers;

import java.util.List;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.ControllerVisitor;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.Session;
import es.urjccode.mastercloudapps.adcs.mastermind.types.Color;
import es.urjccode.mastercloudapps.adcs.mastermind.types.Error;


public abstract class PlayController extends GameController {

	protected PlayController(Session session) {
		super(session);
	}

	public abstract Error addProposedCombination(List<Color> colors);

	public abstract void undo();

	public abstract void redo();

	public abstract void next();

	public abstract boolean undoable();

	public abstract boolean redoable();

	public abstract boolean isWinner();

	public abstract boolean isLooser();

	public abstract List<Color> getColors(int position);
	
	public abstract int getBlacks(int position);
	
	public abstract int getWhites(int position);

	public abstract int getAttempts();

	@Override
	public void accept(ControllerVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
