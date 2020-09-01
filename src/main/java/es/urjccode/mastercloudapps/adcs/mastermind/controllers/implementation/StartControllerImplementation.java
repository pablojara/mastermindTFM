package es.urjccode.mastercloudapps.adcs.mastermind.controllers.implementation;

import java.util.List;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.ControllerImplementation;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.Session;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.SessionImplementationDAO;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.StateValue;
import es.urjccode.mastercloudapps.adcs.mastermind.controllers.StartController;
import es.urjccode.mastercloudapps.adcs.mastermind.models.SessionImplementation;
import es.urjccode.mastercloudapps.adcs.mastermind.types.Color;


@ControllerImplementation(StateValue.INITIAL)
public class StartControllerImplementation extends StartController {

	private SessionImplementationDAO sessionImplementationDAO;

	public StartControllerImplementation(Session session, SessionImplementationDAO sessionImplementationDAO) {
		super(session);
		this.sessionImplementationDAO = sessionImplementationDAO;
	}

	@Override
	public void start() {
		((SessionImplementation)this.session).clearGame();
		((SessionImplementation)this.session).registry();
		//this.sessionImplementationDAO.associate((SessionImplementation)this.session);
		((SessionImplementation) this.session).next();
	}

	@Override
	public void start(String name) {
		this.sessionImplementationDAO.load(name);
	}

	@Override
	public String[] getGamesNames() {
		return this.sessionImplementationDAO.getGamesNames();
	}

	@Override
	public int getAttempts() {
		return ((SessionImplementation) this.session).getAttempts();
	}

	@Override
	public List<Color> getColors(int position) {
		return ((SessionImplementation) this.session).getColors(position);
	}

	@Override
	public int getBlacks(int position) {
		return ((SessionImplementation) this.session).getBlacks(position);
	}

	@Override
	public int getWhites(int position) {
		return ((SessionImplementation) this.session).getWhites(position);
	}

	@Override
	public boolean isWinner() {
		return ((SessionImplementation) this.session).isWinner();
	}

	@Override
	public boolean isLooser() {
		return ((SessionImplementation) this.session).isLooser();
	}

}
