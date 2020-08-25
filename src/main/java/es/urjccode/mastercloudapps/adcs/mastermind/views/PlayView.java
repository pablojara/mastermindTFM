package es.urjccode.mastercloudapps.adcs.mastermind.views;

import es.urjccode.mastercloudapps.adcs.mastermind.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.mastermind.views.menus.PlayMenu;
import es.urjccode.mastercloudapps.adcs.mastermind.views.models.GameView;

class PlayView {

	void interact(PlayController playController) {
		new PlayMenu(playController).execute();
		new GameView(playController).writeln();
	}

}
