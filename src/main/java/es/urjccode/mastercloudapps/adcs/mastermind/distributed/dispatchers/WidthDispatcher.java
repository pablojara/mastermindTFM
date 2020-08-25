package es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers;

import es.urjccode.mastercloudapps.adcs.mastermind.controllers.implementation.PlayControllerImplementation;

public class WidthDispatcher extends Dispatcher {

	public WidthDispatcher(PlayControllerImplementation playControllerImplementation) {
		super(playControllerImplementation);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(this.acceptorController.getWidth());
	}

}
