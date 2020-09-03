package es.urjccode.mastercloudapps.adcs.mastermind.views.menus;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.AceptorController;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.menu.Command;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.menu.MenuCommand;
import es.urjccode.mastercloudapps.adcs.mastermind.controllers.StartController;
import es.urjccode.mastercloudapps.adcs.mastermind.views.models.MessageView;

@MenuCommand(StartMenu.class)
public class NewGameCommand extends Command {

	public NewGameCommand(AceptorController aceptorController) {
		super(MessageView.NEWGAME_COMMAND.getMessage(), aceptorController);
	}

	@Override
	protected void execute() {
		((StartController) this.aceptorController).start();
	}

	@Override
	protected boolean isActive() {
		return true;
	}

}
