package es.urjccode.mastercloudapps.adcs.mastermind.views.menus;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.AceptorController;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.menu.Command;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.menu.MenuCommand;
import es.urjccode.mastercloudapps.adcs.mastermind.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.mastermind.views.models.MessageView;

@MenuCommand(PlayMenu.class)
public class RedoCommand extends Command {
	
	public RedoCommand(AceptorController aceptorController) {
		super(MessageView.REDO_COMMAND.getMessage(), aceptorController);
	}

	@Override
	protected void execute() {
		((PlayController) this.aceptorController).redo();
	}

	@Override
	protected boolean isActive() {
		return ((PlayController) this.aceptorController).redoable();
	}

}
