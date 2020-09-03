package es.urjccode.mastercloudapps.adcs.mastermind.views;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.AceptorController;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.models.StateValue;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.SubView;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.SubViewImplementation;
import es.urjccode.mastercloudapps.adcs.mastermind.controllers.StartController;
import es.urjccode.mastercloudapps.adcs.mastermind.views.menus.StartMenu;
import es.urjccode.mastercloudapps.adcs.mastermind.views.models.GameView;
import es.urjccode.mastercloudapps.adcs.mastermind.views.models.MessageView;


@SubViewImplementation(StateValue.INITIAL)
public class StartView extends SubView {

	public StartView(){
		super();
	}

	public void interact(AceptorController aceptorController) {
		MessageView.TITLE.writeln();
		new StartMenu(aceptorController).execute();
		new GameView((StartController)aceptorController).writeln();
	}

}
