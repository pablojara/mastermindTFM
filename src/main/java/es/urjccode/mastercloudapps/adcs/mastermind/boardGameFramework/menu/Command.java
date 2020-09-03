package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.menu;


import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.AceptorController;

public abstract class Command {


	protected AceptorController aceptorController;

	protected Command(String title, AceptorController acceptorController) {
		this.title = title;
		this.aceptorController = acceptorController;
	}

	protected String title;

	protected abstract void execute();

	protected abstract boolean isActive();

	String getTitle() {
		return this.title;
	}
}
