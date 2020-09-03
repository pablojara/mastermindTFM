package es.urjccode.mastercloudapps.adcs.mastermind.views;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.AceptorController;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.models.StateValue;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.SubView;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.SubViewImplementation;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.controllers.ResumeController;
import es.urjccode.mastercloudapps.adcs.mastermind.views.models.MessageView;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.utils.YesNoDialog;

@SubViewImplementation(StateValue.FINAL)
public class ResumeView extends SubView {

	public ResumeView(){
		super();
	}

	public void interact(AceptorController aceptorController) {
		((ResumeController)aceptorController).isNewGame(new YesNoDialog().read(MessageView.RESUME.getMessage()));
	}

}
