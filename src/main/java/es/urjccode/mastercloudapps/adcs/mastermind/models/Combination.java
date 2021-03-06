package es.urjccode.mastercloudapps.adcs.mastermind.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.memento.MementoAttribute;
import es.urjccode.mastercloudapps.adcs.mastermind.types.Color;

public abstract class Combination extends MementoAttribute implements Serializable {
	
	private static final int WIDTH = 4;

	protected List<Color> colors;
	
	protected Combination (){
		this.colors = new ArrayList<Color>();
	}

	public void clearColors() {
		this.colors.clear();
	}

	public void addColor(Color color) {
		this.colors.add(color);
	}
	
	public static int getWidth() {
		return Combination.WIDTH;
	}

	public List<Color> getColors() {
		return this.colors;
	}
	
}
