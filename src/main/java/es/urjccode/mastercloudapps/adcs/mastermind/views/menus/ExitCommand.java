package es.urjccode.mastercloudapps.adcs.mastermind.views.menus;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.AceptorController;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.menu.Command;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.menu.MenuCommand;
import es.urjccode.mastercloudapps.adcs.mastermind.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.mastermind.views.models.MessageView;

@MenuCommand(PlayMenu.class)
public class ExitCommand extends Command {

	public ExitCommand(AceptorController aceptorController) {
		super(MessageView.EXIT_COMMAND.getMessage(), aceptorController);
	}

	@Override
	protected void execute() {
		((PlayController) this.aceptorController).next();
	}

	@Override
	protected boolean isActive() {
		return true;
	}

}
