package es.urjccode.mastercloudapps.adcs.mastermind.utils;

public abstract class Command {

	private Console console;

	protected String title;
	
	protected Command(String title) {
		this.title = title;
	}

	protected abstract void execute();

	protected abstract boolean isActive();

	String getTitle() {
		return this.title;
	}

}
