package es.urjccode.mastercloudapps.adcs.mastermind.distributed;

import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.DispatcherPrototype;
import es.urjccode.mastercloudapps.adcs.mastermind.models.DAO.SessionImplementationDAO;

public class MastermindServer {

	private DispatcherPrototype dispatcherPrototype;

	private LogicImplementationServer logic;

	private MastermindServer() {
		this.dispatcherPrototype = new DispatcherPrototype();
		this.logic = new LogicImplementationServer(new SessionImplementationDAO());
		this.logic.createDispatchers(this.dispatcherPrototype);
	}

	private void serve() {
		this.dispatcherPrototype.serve();
	}

	public static void main(String[] args) {
		new MastermindServer().serve();
	}

}
