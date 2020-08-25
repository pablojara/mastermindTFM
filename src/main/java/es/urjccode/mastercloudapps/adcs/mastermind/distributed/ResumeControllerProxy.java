package es.urjccode.mastercloudapps.adcs.mastermind.distributed;

import es.urjccode.mastercloudapps.adcs.mastermind.controllers.ResumeController;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.FrameType;
import es.urjccode.mastercloudapps.adcs.mastermind.models.Session;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.TCPIP;

public class ResumeControllerProxy extends ResumeController {
	
	private TCPIP tcpip;

	ResumeControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public void isNewGame(boolean newGame) {
		this.tcpip.send(FrameType.NEW_GAME.name());
		this.tcpip.send(newGame);	
	}

}
