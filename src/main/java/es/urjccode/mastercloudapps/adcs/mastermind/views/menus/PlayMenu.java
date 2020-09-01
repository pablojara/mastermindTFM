package es.urjccode.mastercloudapps.adcs.mastermind.views.menus;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.AceptorController;
import es.urjccode.mastercloudapps.adcs.mastermind.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.mastermind.utils.Menu;

public class PlayMenu extends Menu {

	public PlayMenu(AceptorController aceptorController) {
		this.addCommand(new ProposeCommand(aceptorController));
		this.addCommand(new UndoCommand(aceptorController));
		this.addCommand(new RedoCommand(aceptorController));
		this.addCommand(new ExitCommand(aceptorController));
	}

}
