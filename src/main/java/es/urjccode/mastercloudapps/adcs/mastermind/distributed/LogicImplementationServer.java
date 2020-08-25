package es.urjccode.mastercloudapps.adcs.mastermind.distributed;

import es.urjccode.mastercloudapps.adcs.mastermind.controllers.implementation.LogicImplementation;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.ColorsDispatcher;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.DispatcherPrototype;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.ExistsDispatcher;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.FrameType;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.GetTitleDispatcher;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.HasNameDispatcher;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.LooserDispatcher;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.NextDispatcher;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.ProposeCombinationDispatcher;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.RedoDispatcher;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.RedoableDispatcher;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.ResumeDispatcher;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.SaveDispatcher;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.SaveNamedDispatcher;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.SetTitleDispatcher;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.StartDispatcher;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.StartNameDispatcher;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.StateDispatcher;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.TitlesDispatcher;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.AttemptsDispatcher;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.BlacksDispatcher;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.UndoDispatcher;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.UndoableDispatcher;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.WhitesDispatcher;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.WidthDispatcher;
import es.urjccode.mastercloudapps.adcs.mastermind.distributed.dispatchers.WinnerDispatcher;
import es.urjccode.mastercloudapps.adcs.mastermind.models.DAO.SessionImplementationDAO;

public class LogicImplementationServer extends LogicImplementation {

	public LogicImplementationServer(SessionImplementationDAO sessionImplementationDAO) {
		super(sessionImplementationDAO);
	}

	public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
		dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.startControllerImplementation));
		dispatcherPrototype.add(FrameType.START_NAME, new StartNameDispatcher(this.startControllerImplementation));
		dispatcherPrototype.add(FrameType.TITLES, new TitlesDispatcher(this.startControllerImplementation));
		dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.WINNER, new WinnerDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.LOOSER, new LooserDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.ATTEMPTS, new AttemptsDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.COLORS, new ColorsDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.PROPOSECOMBINATION,
				new ProposeCombinationDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.WIDTH, new WidthDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.NEXT, new NextDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.BLACKS, new BlacksDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.WHITES, new WhitesDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.SAVE, new SaveDispatcher(this.saveControllerImplementation));
		dispatcherPrototype.add(FrameType.SAVE_NAMED, new SaveNamedDispatcher(this.saveControllerImplementation));
		dispatcherPrototype.add(FrameType.HAS_NAME, new HasNameDispatcher(this.saveControllerImplementation));
		dispatcherPrototype.add(FrameType.EXISTS, new ExistsDispatcher(this.saveControllerImplementation));
		dispatcherPrototype.add(FrameType.GET_TITLE, new GetTitleDispatcher(this.saveControllerImplementation));
		dispatcherPrototype.add(FrameType.SET_TITLE, new SetTitleDispatcher(this.saveControllerImplementation));
		dispatcherPrototype.add(FrameType.NEW_GAME, new ResumeDispatcher(this.resumeControllerImplementation));
	}

}
