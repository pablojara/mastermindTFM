package es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers;

import es.urjccode.mastercloudapps.adcs.mastermind.controllers.AcceptorController;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.TCPIP;

public abstract class Dispatcher {
	
	protected AcceptorController acceptorController;
	
	protected TCPIP tcpip;
	
	public Dispatcher (AcceptorController acceptorController) {
		this.acceptorController = acceptorController;
	}

	public abstract void dispatch();
	
	public void associate(TCPIP tcpip) {
		this.tcpip = tcpip;
	}

}
