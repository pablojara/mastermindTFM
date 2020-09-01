package es.urjccode.mastercloudapps.adcs.mastermind.views.menus;


import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.AceptorController;

abstract class Command extends es.urjccode.mastercloudapps.adcs.mastermind.utils.Command {

	protected AceptorController acceptorController;

	protected Command(String title, AceptorController acceptorController) {
		super(title);
		this.acceptorController = acceptorController;
	}
	
}
