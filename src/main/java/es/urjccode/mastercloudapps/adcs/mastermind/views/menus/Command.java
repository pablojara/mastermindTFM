package es.urjccode.mastercloudapps.adcs.mastermind.views.menus;


import es.urjccode.mastercloudapps.adcs.mastermind.controllers.AcceptorController;

abstract class Command extends es.urjccode.mastercloudapps.adcs.mastermind.utils.Command {

	protected AcceptorController acceptorController;

	protected Command(String title, AcceptorController acceptorController) {
		super(title);
		this.acceptorController = acceptorController;
	}
	
}
