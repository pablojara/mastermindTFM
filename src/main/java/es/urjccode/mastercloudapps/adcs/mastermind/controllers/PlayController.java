package es.urjccode.mastercloudapps.adcs.mastermind.controllers;

import java.util.List;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.ControllerVisitor;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.controllers.ExitController;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.controllers.RedoController;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.controllers.UndoController;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.models.Session;
import es.urjccode.mastercloudapps.adcs.mastermind.types.Color;
import es.urjccode.mastercloudapps.adcs.mastermind.types.Error;


public abstract class PlayController extends GameController {

	protected ProposalController proposalController;

	protected UndoController undoController;

	protected RedoController redoController;

	protected ExitController exitController;

	protected PlayController(Session session) {
		super(session);
		this.proposalController = new ProposalController(this.session);
		this.undoController = new UndoController(this.session);
		this.redoController = new RedoController(this.session);
		this.exitController = new ExitController(this.session);
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
