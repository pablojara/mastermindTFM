package es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers;

import es.urjccode.mastercloudapps.adcs.mastermind.controllers.implementation.SaveControllerImplementation;

public class HasNameDispatcher extends Dispatcher {

	public HasNameDispatcher(SaveControllerImplementation saveControllerImplementation) {
		super(saveControllerImplementation);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((SaveControllerImplementation) this.acceptorController).hasName());
	}

}
