package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework;

import es.urjccode.mastercloudapps.adcs.mastermind.models.GameImplementation;
import es.urjccode.mastercloudapps.adcs.mastermind.controllers.implementation.LogicImplementation;
import es.urjccode.mastercloudapps.adcs.mastermind.models.SessionImplementation;

class BoardGame {

    private View view;

    private Logic logic;

    private BoardGame()  {
        this.view = new View();
        this.logic = new LogicImplementation(new SessionImplementation(new GameImplementation()));
    }

    private void play() {
        AceptorController acceptorController;
		do {
            acceptorController = this.logic.getController();
			if (acceptorController != null)
				this.view.interact(acceptorController);
		} while (acceptorController != null);
    }

    public static void main(String[] args)  {
        new BoardGame().play();
    }

}
