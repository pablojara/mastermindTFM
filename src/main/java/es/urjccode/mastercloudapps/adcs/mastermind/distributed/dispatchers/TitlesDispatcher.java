package es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers;

import es.urjccode.mastercloudapps.adcs.mastermind.controllers.implementation.StartControllerImplementation;

public class TitlesDispatcher extends Dispatcher {

	public TitlesDispatcher(StartControllerImplementation startControllerImplementation) {
		super(startControllerImplementation);
	}

	@Override
	public void dispatch() {
		String[] names = ((StartControllerImplementation) this.acceptorController).getGamesNames();
		this.tcpip.send(names.length);
		for (int i = 0; i < names.length; i++) {
			this.tcpip.send(names[i]);
		}
	}

}