package es.urjccode.mastercloudapps.adcs.mastermind.views.menus;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.AceptorController;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.menu.Command;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.menu.MenuCommand;
import es.urjccode.mastercloudapps.adcs.mastermind.controllers.StartController;
import es.urjccode.mastercloudapps.adcs.mastermind.views.models.MessageView;

@MenuCommand(StartMenu.class)
public class OpenGameCommand extends Command {

	public OpenGameCommand(AceptorController aceptorController) {
		super(MessageView.OPENGAME_COMMAND.getMessage(), aceptorController);
	}

	@Override
	protected void execute() {
		new GameSelectMenu((StartController) this.aceptorController).execute();
	}

	@Override
	protected boolean isActive() {
		return true;
	}

}
