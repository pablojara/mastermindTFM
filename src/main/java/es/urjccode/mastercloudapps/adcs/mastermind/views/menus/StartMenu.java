package es.urjccode.mastercloudapps.adcs.mastermind.views.menus;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.AceptorController;
import es.urjccode.mastercloudapps.adcs.mastermind.controllers.StartController;
import es.urjccode.mastercloudapps.adcs.mastermind.utils.Menu;

public class StartMenu extends Menu {

	public StartMenu(AceptorController aceptorController) {
		this.addCommand(new NewGameCommand(aceptorController));
		this.addCommand(new OpenGameCommand(aceptorController));
	}
}
