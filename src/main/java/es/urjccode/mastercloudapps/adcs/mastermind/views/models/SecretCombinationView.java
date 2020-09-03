package es.urjccode.mastercloudapps.adcs.mastermind.views.models;

import es.urjccode.mastercloudapps.adcs.mastermind.controllers.GameController;

class SecretCombinationView {

	private GameController gameController;

	public SecretCombinationView(GameController gameController) {
		this.gameController = gameController;
	}
	
	void writeln() {
		for (int i = 0; i < this.gameController.getWidth(); i++) {
			MessageView.SECRET.write();
		}
		MessageView.NEW_LINE.writeln();
	}
	
}
