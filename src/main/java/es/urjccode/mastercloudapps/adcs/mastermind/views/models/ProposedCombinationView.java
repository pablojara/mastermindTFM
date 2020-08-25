package es.urjccode.mastercloudapps.adcs.mastermind.views.models;

import java.util.ArrayList;
import java.util.List;

import es.urjccode.mastercloudapps.adcs.mastermind.controllers.GameController;
import es.urjccode.mastercloudapps.adcs.mastermind.types.Color;
import es.urjccode.mastercloudapps.adcs.mastermind.views.models.ColorView;
import es.urjccode.mastercloudapps.adcs.mastermind.utils.WithConsoleView;

public class ProposedCombinationView extends WithConsoleView {
	
	private GameController gameController;
	
	public ProposedCombinationView(GameController gameController) {
		this.gameController = gameController;
	}
	
	void write(int i) {
		for (Color color : this.gameController.getColors(i)) {
			new ColorView(color).write();
		}
	}

	public List<Color> read() {
		String characters = this.console.readString(MessageView.PROPOSED_COMBINATION.getMessage());
		List<Color> colors = new ArrayList<Color>();
		for (int i=0; i<characters.length(); i++) {
			colors.add(ColorView.getInstance(characters.charAt(i)));
		}
		return colors;
	}
	
}
