package es.urjccode.mastercloudapps.adcs.mastermind.controllers.implementation;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.ControllerImplementation;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.Session;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.SessionImplementationDAO;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.StateValue;
import es.urjccode.mastercloudapps.adcs.mastermind.controllers.ResumeController;
import es.urjccode.mastercloudapps.adcs.mastermind.models.SessionImplementation;

@ControllerImplementation(StateValue.FINAL)
public class ResumeControllerImplementation extends ResumeController {

	public ResumeControllerImplementation(Session session, SessionImplementationDAO sessionImplementationDAO) {
		super(session);
	}

	@Override
	public void isNewGame(boolean newGame) {
		if (newGame) {
			((SessionImplementation) this.session).isNewGame();
		} else {
			((SessionImplementation) this.session).next();
		}
	}

}
