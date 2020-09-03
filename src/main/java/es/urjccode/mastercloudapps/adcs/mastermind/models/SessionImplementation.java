package es.urjccode.mastercloudapps.adcs.mastermind.models;

import java.util.List;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.memento.Registry;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.models.Session;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.models.StateValue;
import es.urjccode.mastercloudapps.adcs.mastermind.types.Color;

public class SessionImplementation extends Session {


	public SessionImplementation(GameImplementation game) {
		super(game);
	}

	public void next() {
		this.state.next();
	}

	public void addProposedCombination(List<Color> colors) {
		((GameImplementation)this.game).addProposedCombination(colors);
		this.registry.registry();
	}

	public boolean undoable() {
		return this.registry.undoable();
	}

	public boolean redoable() {
		return this.registry.redoable();
	}

	public void undo() {
		this.registry.undo(this.game);
	}

	public void redo() {
		this.registry.redo(this.game);
	}

	public void isNewGame() {
		((GameImplementation)this.game).clear();
		this.state.reset();
		this.registry.reset();
		this.name = null;
	}

	public void clearGame() {
		this.game = new GameImplementation();
	}

	public void registry()  {
		this.registry = new Registry(this.game);
	}

	public void resetRegistry() {
		this.registry.reset();
	}

	public void setStateValue(StateValue stateValue) {
		this.state.setStateValue(stateValue);
	}

	public boolean isWinner() {
		return ((GameImplementation)this.game).isWinner();
	}

	public boolean isLooser() {
		return ((GameImplementation)this.game).isLooser();
	}

	public List<Color> getColors(int i) {
		return ((GameImplementation)this.game).getColors(i);
	}

	public int getAttempts() {
		return ((GameImplementation)this.game).getAttempts();
	}

	public int getBlacks(int i) {
		return ((GameImplementation)this.game).getBlacks(i);
	}

	public int getWhites(int i) {
		return ((GameImplementation)this.game).getWhites(i);
	}

	public boolean hasName() {
		return this.name != null;
	}

	public GameImplementation getGame() {
		return ((GameImplementation)this.game);
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public int getWidth() {
		return ((GameImplementation)this.game).getWidth();
	}

	@Override
	public StateValue getValueState() {
		return this.state.getValueState();
	}

}
