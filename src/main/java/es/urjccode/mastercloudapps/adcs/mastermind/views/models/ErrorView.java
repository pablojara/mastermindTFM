package es.urjccode.mastercloudapps.adcs.mastermind.views.models;

import es.urjccode.mastercloudapps.adcs.mastermind.types.Error;
import es.urjccode.mastercloudapps.adcs.mastermind.utils.Console;

public class ErrorView {

	private Console console;

	static final String[] MESSAGES = { 
		"Repeated colors",
		"Wrong colors, they must be: " + ColorView.allInitials(), 
		"Wrong proposed combination length" };

	Error error;

	public ErrorView(Error error) {
		this.error = error;
		this.console = new Console();
	}
	
	public void writeln() {
		this.console.writeln(ErrorView.MESSAGES[this.error.ordinal()]);
	}	
	
}
