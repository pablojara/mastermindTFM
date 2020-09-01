package es.urjccode.mastercloudapps.adcs.mastermind.views;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.AceptorController;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.StateValue;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.SubView;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.SubViewImplementation;
import es.urjccode.mastercloudapps.adcs.mastermind.controllers.ResumeController;
import es.urjccode.mastercloudapps.adcs.mastermind.views.models.MessageView;
import es.urjccode.mastercloudapps.adcs.mastermind.utils.YesNoDialog;

@SubViewImplementation(StateValue.FINAL)
public class ResumeView extends SubView {

	public ResumeView(){
		super();
	}

	public void interact(AceptorController aceptorController) {
		((ResumeController)aceptorController).isNewGame(new YesNoDialog().read(MessageView.RESUME.getMessage()));
	}

}
