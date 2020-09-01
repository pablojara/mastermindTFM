package es.urjccode.mastercloudapps.adcs.mastermind.controllers;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.AceptorController;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.ControllerVisitor;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.Session;

public abstract class SaveController extends AceptorController {

	public SaveController(Session session) {
		super(session);
	}

	public abstract void save(String name);

	public abstract void save();

	public abstract void next();

	public abstract boolean hasName();

	public abstract boolean exists(String readString);

	@Override
	public void accept(ControllerVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
