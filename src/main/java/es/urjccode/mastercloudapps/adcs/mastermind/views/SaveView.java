package es.urjccode.mastercloudapps.adcs.mastermind.views;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.AceptorController;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.models.StateValue;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.SubView;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.SubViewImplementation;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.controllers.SaveController;
import es.urjccode.mastercloudapps.adcs.mastermind.views.models.MessageView;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.utils.YesNoDialog;

@SubViewImplementation(StateValue.SAVING)
public class SaveView extends SubView {

	public SaveView(){
		super();
	}

	public void interact(AceptorController aceptorController) {
		boolean save = new YesNoDialog().read(MessageView.SAVE.getMessage());
		String name = null;
		if (save) {
			if (((SaveController)aceptorController).hasName()) {
				((SaveController)aceptorController).save();
			} else {
				boolean exists = false;
				do {
					name = this.console.readString(MessageView.NAME.getMessage());
					exists = ((SaveController)aceptorController).exists(name);
					if (exists) {
						this.console.writeln("The proposed name already exists");
					}
				} while (exists);
				((SaveController)aceptorController).save(name);
			}
		}
		((SaveController)aceptorController).next();
	}

}
