package es.urjccode.mastercloudapps.adcs.mastermind.views;

import es.urjccode.mastercloudapps.adcs.mastermind.controllers.*;

public class View implements ControllersVisitor {
	
	private StartView startView;
	
	private PlayView playView;
	
	private SaveView saveView;
	
	private ResumeView resumeView;
	
	public View(){
		this.startView = new StartView();
		this.playView = new PlayView();
		this.saveView = new SaveView();
		this.resumeView = new ResumeView();
	}
	
	public void interact(AcceptorController acceptorController) {
		acceptorController.accept(this);
	}

	@Override
	public void visit(StartController startController) {
		this.startView.interact(startController);		
	}

	@Override
	public void visit(PlayController playController) {
		this.playView.interact(playController);
	}
	
	@Override
	public void visit(SaveController saveController) {
		this.saveView.interact(saveController);
	}

	@Override
	public void visit(ResumeController resumeController) {
		this.resumeView.interact(resumeController);
	}

}
