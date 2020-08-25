package es.urjccode.mastercloudapps.adcs.mastermind.views.models;

import es.urjccode.mastercloudapps.adcs.mastermind.controllers.GameController;

class AttemptsView {

	private GameController gameController;

	AttemptsView(GameController gameController) {
		this.gameController = gameController;
	}

	void writeln() {
		MessageView.ATTEMPTS.writeln(this.gameController.getAttempts());
	}

}
