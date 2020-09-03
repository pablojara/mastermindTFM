package es.urjccode.mastercloudapps.adcs.mastermind.models;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.memento.MementoAttribute;

import java.io.Serializable;

public class Result extends MementoAttribute implements Serializable {

	private int blacks = 0;

	private int whites = 0;

	Result(int blacks, int whites) {
		assert blacks >= 0;
		assert whites >= 0;
		this.blacks = blacks;
		this.whites = whites;
	}

	public Result() {
	}

	Result copy() {
		return new Result(this.blacks, this.whites);
	}

	public void setBlacks(int blacks) {
		this.blacks = blacks;
	}
	
	public void setWhites(int whites) {
		this.whites = whites;
	}

	boolean isWinner() {
		return this.blacks == Combination.getWidth();
	}

	public int getBlacks() {
		return this.blacks;
	}

	public int getWhites() {
		return this.whites;
	}

	@Override
	public String toString() {
		return "Result [blacks=" + blacks + ", whites=" + whites + "]";
	}

	@Override
	public void initializeMemento(MementoAttribute mementoAttribute) {

	}
}
