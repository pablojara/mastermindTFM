package es.urjccode.mastercloudapps.adcs.mastermind.views.menus;

import java.util.List;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.AceptorController;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.menu.Command;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.menu.MenuCommand;
import es.urjccode.mastercloudapps.adcs.mastermind.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.mastermind.types.Color;
import es.urjccode.mastercloudapps.adcs.mastermind.types.Error;
import es.urjccode.mastercloudapps.adcs.mastermind.views.models.ErrorView;
import es.urjccode.mastercloudapps.adcs.mastermind.views.models.GameView;
import es.urjccode.mastercloudapps.adcs.mastermind.views.models.MessageView;
import es.urjccode.mastercloudapps.adcs.mastermind.views.models.ProposedCombinationView;

@MenuCommand(PlayMenu.class)
public class ProposeCommand extends Command {

	public ProposeCommand(AceptorController aceptorController) {
		super(MessageView.PROPOSE_COMMAND.getMessage(), aceptorController);
	}

	@Override
	protected void execute() {
		Error error;
		do {
			List<Color> colors = new ProposedCombinationView((PlayController)this.aceptorController).read();
			error = ((PlayController)this.aceptorController).addProposedCombination(colors);
			if (error != null) {
				new ErrorView(error).writeln();
			}
		} while (error != null);
		new GameView((PlayController)this.aceptorController);
	}

	@Override
	protected boolean isActive() {
		return true;
	}

}
