package es.urjccode.mastercloudapps.adcs.mastermind.controllers.implementation;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.ControllerImplementation;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.models.Session;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.DAO.SessionImplementationDAO;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.models.StateValue;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.controllers.ResumeController;
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
