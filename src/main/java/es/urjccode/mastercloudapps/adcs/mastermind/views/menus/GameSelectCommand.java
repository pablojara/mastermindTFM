package es.urjccode.mastercloudapps.adcs.mastermind.views.menus;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.menu.Command;
import es.urjccode.mastercloudapps.adcs.mastermind.controllers.StartController;

public class GameSelectCommand extends Command {

	public GameSelectCommand(String title, StartController startController) {
		super(title, startController);
	}

	@Override
	protected void execute() {
		System.out.println(this.title);
		((StartController) this.aceptorController).start(this.title);
	}

	@Override
	protected boolean isActive() {
		return true;
	}

}
