package es.urjccode.mastercloudapps.adcs.mastermind.views;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.AceptorController;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.StateValue;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.SubView;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.SubViewImplementation;
import es.urjccode.mastercloudapps.adcs.mastermind.controllers.GameController;
import es.urjccode.mastercloudapps.adcs.mastermind.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.mastermind.views.menus.PlayMenu;
import es.urjccode.mastercloudapps.adcs.mastermind.views.models.GameView;

@SubViewImplementation(StateValue.IN_GAME)
public class PlayView extends SubView {

	public PlayView() {
		super();
	}

	public void interact(AceptorController aceptorController) {
		new PlayMenu(aceptorController).execute();
		new GameView((GameController)aceptorController).writeln();
	}

}
