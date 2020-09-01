package es.urjccode.mastercloudapps.adcs.mastermind;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.Logic;
import es.urjccode.mastercloudapps.adcs.mastermind.controllers.implementation.LogicImplementation;
import es.urjccode.mastercloudapps.adcs.mastermind.models.GameImplementation;
import es.urjccode.mastercloudapps.adcs.mastermind.models.SessionImplementation;

public class MastermindStandalone extends Mastermind{

	@Override
	protected Logic createLogic() {
		return new LogicImplementation(new SessionImplementation(new GameImplementation()));
	}
	
	public static void main(String[] args) {
		new MastermindStandalone().play();
	}

}
