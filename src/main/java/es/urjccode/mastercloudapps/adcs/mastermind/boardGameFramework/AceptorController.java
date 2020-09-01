package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework;

public abstract class AceptorController extends Controller {

    public AceptorController(Session session) {
        super(session);
    }

	abstract public void accept(ControllerVisitor controllersVisitor);

}
