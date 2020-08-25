package es.urjccode.mastercloudapps.adcs.mastermind.views;

import es.urjccode.mastercloudapps.adcs.mastermind.controllers.StartController;
import es.urjccode.mastercloudapps.adcs.mastermind.views.menus.StartMenu;
import es.urjccode.mastercloudapps.adcs.mastermind.views.models.GameView;
import es.urjccode.mastercloudapps.adcs.mastermind.views.models.MessageView;

class StartView {

	void interact(StartController startController) {
		MessageView.TITLE.writeln();
		new StartMenu(startController).execute();
		new GameView(startController).writeln();
	}

}
