package es.urjccode.mastercloudapps.adcs.mastermind;


import es.urjccode.mastercloudapps.adcs.mastermind.controllers.AcceptorController;
import es.urjccode.mastercloudapps.adcs.mastermind.controllers.Logic;
import es.urjccode.mastercloudapps.adcs.mastermind.views.View;

public abstract class Mastermind {
	
	private Logic logic;
	
	private View view;
	
	protected Mastermind() {
		this.logic = this.createLogic();
		this.view = new View();
	}
	
	protected abstract Logic createLogic();

	protected void play() {
		AcceptorController acceptorController;
		do {
			acceptorController = this.logic.getController();
			if (acceptorController != null){
				this.view.interact(acceptorController);
			}
		} while (acceptorController != null); 
	}
	
}

