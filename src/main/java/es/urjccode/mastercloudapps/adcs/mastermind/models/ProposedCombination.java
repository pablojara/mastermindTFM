package es.urjccode.mastercloudapps.adcs.mastermind.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.memento.MementoAttribute;
import es.urjccode.mastercloudapps.adcs.mastermind.types.Color;

public class ProposedCombination extends Combination implements Serializable {

	ProposedCombination(List<Color> colors) {
		this.colors = colors;
	}

	public ProposedCombination() {
	}

	boolean contains(Color color, int position) {
		return this.colors.get(position) == color;
	}

	boolean contains(Color color) {
		for (int i = 0; i < this.colors.size(); i++) {
			if (this.colors.get(i) == color) {
				return true;
			}
		}
		return false;
	}
	
	ProposedCombination copy() {
		List<Color> colors = new ArrayList<Color>();
		for(Color color: this.colors) {
			colors.add(color);
		}
		return new ProposedCombination(colors);
	}

	@Override
	public String toString() {
		return "ProposedCombination [colors=" + colors + "]";
	}

	@Override
	public void initializeMemento(MementoAttribute mementoAttribute) {
		ProposedCombination tmpCombination = (ProposedCombination) mementoAttribute;
		List<Color> tmpColors = new ArrayList<Color>();
		for(Color color: tmpCombination.colors){
			tmpColors.add(color);
		}
		this.colors = tmpColors;	}
}
