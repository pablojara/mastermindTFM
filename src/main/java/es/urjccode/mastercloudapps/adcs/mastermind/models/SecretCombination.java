package es.urjccode.mastercloudapps.adcs.mastermind.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.memento.MementoAttribute;
import es.urjccode.mastercloudapps.adcs.mastermind.types.Color;

public class SecretCombination extends Combination implements Serializable {

	public SecretCombination() {
		for(Color color: Color.values()) {
			this.colors.add(color);
		}
		Random random = new Random(System.currentTimeMillis());
		for (int i = 0; i < Color.length() - Combination.getWidth(); i++) {
			this.colors.remove(random.nextInt(this.colors.size()));
		}
		Collections.shuffle(this.colors);
	}

	Result getResult(ProposedCombination proposedCombination) {
		int blacks = 0;
		System.out.println(this.colors.size());
		for (int i = 0; i < this.colors.size(); i++) {
			if (proposedCombination.contains(this.colors.get(i), i)) {
				blacks++;
			}
		}
		int whites = 0;
		for (Color color : this.colors) {
			if (proposedCombination.contains(color)) {
				whites++;
			}
		}
		return new Result(blacks, whites - blacks);
	}

	@Override
	public String toString() {
		return "SecretCombination [colors=" + colors + "]";
	}

	@Override
	public void initializeMemento(MementoAttribute mementoAttribute) {
			SecretCombination tmpCombination = (SecretCombination) mementoAttribute;
			List<Color> tmpColors = new ArrayList<Color>();
			for(Color color: tmpCombination.colors){
				tmpColors.add(color);
			}
			this.colors = tmpColors;

	}
}
