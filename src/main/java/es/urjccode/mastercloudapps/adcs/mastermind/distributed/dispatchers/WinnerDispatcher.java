package es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers;

import es.urjccode.mastercloudapps.adcs.mastermind.controllers.implementation.PlayControllerImplementation;

public class WinnerDispatcher extends Dispatcher {

	public WinnerDispatcher(PlayControllerImplementation playControllerImplementation) {
		super(playControllerImplementation);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayControllerImplementation)this.acceptorController).isWinner());
	}

}
