package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.controllers.Controller;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.models.Session;

public abstract class AceptorController extends Controller {

    public AceptorController(Session session) {
        super(session);
    }

	abstract public void accept(ControllerVisitor controllersVisitor);

}
