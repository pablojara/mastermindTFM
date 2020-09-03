package es.urjccode.mastercloudapps.adcs.mastermind.views;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.AceptorController;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.models.StateValue;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.SubView;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.SubViewImplementation;
import es.urjccode.mastercloudapps.adcs.mastermind.controllers.GameController;
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
