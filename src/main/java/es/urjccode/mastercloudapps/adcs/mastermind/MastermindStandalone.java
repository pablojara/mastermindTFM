package es.urjccode.mastercloudapps.adcs.mastermind;

import es.urjccode.mastercloudapps.adcs.mastermind.controllers.Logic;
import es.urjccode.mastercloudapps.adcs.mastermind.controllers.implementation.LogicImplementation;
import es.urjccode.mastercloudapps.adcs.mastermind.models.DAO.SessionImplementationDAO;

public class MastermindStandalone extends Mastermind{

	@Override
	protected Logic createLogic() {
		return new LogicImplementation(new SessionImplementationDAO());
	}
	
	public static void main(String[] args) {
		new MastermindStandalone().play();
	}

}
