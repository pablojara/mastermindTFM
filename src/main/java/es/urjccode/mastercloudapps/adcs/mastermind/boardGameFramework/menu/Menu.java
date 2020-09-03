package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.menu;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.AceptorController;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.utils.ClosedInterval;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.utils.Console;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Set;

public abstract class Menu {

	private Console console;

	private static final String OPTION = "----- Choose one option -----";
	
	private ArrayList<Command> commandList;

    public Menu(AceptorController aceptorController) {
    	this.console = new Console();
		this.commandList = new ArrayList<Command>();

		Reflections reflections = new Reflections("es.urjccode.mastercloudapps.adcs");
		Set<Class<?>> commands = reflections.getTypesAnnotatedWith(MenuCommand.class);
		try {
			for (Class<?> command : commands) {
				MenuCommand annotation = command.getAnnotation(MenuCommand.class);
				if(annotation.value() == this.getClass()) {
					Constructor constructor = command.getConstructor(AceptorController.class);
					Command commandInstance = (Command) constructor.newInstance(aceptorController);
					this.commandList.add(commandInstance);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

    }

	public void execute() {
		ArrayList<Command> commands = new ArrayList<Command>();
		for (int i = 0; i < this.commandList.size(); i++) {
			if (this.commandList.get(i).isActive()) {
				commands.add(this.commandList.get(i));
			}
		}
		boolean error;
		int option;
		do {
			error = false;
			this.console.writeln();
			this.console.writeln(Menu.OPTION);
			for (int i = 0; i < commands.size(); i++) {
				this.console.writeln((i + 1) + ") " + commands.get(i).getTitle());
			}
			option = this.console.readInt("") - 1;
			if (!new ClosedInterval(0, commands.size()-1).includes(option)) {
				error = true;
			} 				
		} while (error);
		commands.get(option).execute();
	}

	protected void addCommand(Command command) {
		this.commandList.add(command);
	}

}
