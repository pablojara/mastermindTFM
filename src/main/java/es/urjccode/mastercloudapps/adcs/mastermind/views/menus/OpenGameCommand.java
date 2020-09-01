package es.urjccode.mastercloudapps.adcs.mastermind.views.menus;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.AceptorController;
import es.urjccode.mastercloudapps.adcs.mastermind.controllers.StartController;
import es.urjccode.mastercloudapps.adcs.mastermind.views.models.MessageView;

class OpenGameCommand extends Command{

	protected OpenGameCommand(AceptorController aceptorController) {
		super(MessageView.OPENGAME_COMMAND.getMessage(), aceptorController);
	}

	@Override
	protected void execute() {
		new GameSelectMenu((StartController) this.acceptorController).execute();
	}

	@Override
	protected boolean isActive() {
		return true;
	}

}
