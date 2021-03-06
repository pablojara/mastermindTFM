package es.urjccode.mastercloudapps.adcs.mastermind;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.models.Application;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.models.BoardGame;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.Logic;
import es.urjccode.mastercloudapps.adcs.mastermind.models.GameImplementation;
import es.urjccode.mastercloudapps.adcs.mastermind.models.SessionImplementation;


@Application
public class Mastermind extends BoardGame {

	public Mastermind() {
		super();
		this.logic = new Logic(new SessionImplementation(new GameImplementation()));
	}

}
