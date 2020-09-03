package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.DAO.SessionImplementationDAO;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.AceptorController;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection.ControllerImplementation;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.models.Session;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.models.StateValue;
import es.urjccode.mastercloudapps.adcs.mastermind.models.SessionImplementation;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Logic {

    protected Session session;

    protected Map<StateValue, AceptorController> acceptorControllers;

    public Logic(Session session) {
        this.session = session;
        this.acceptorControllers = new HashMap<StateValue, AceptorController>();
        SessionImplementationDAO sessionImplementationDAO = new SessionImplementationDAO((SessionImplementation) this.session);
        Reflections reflections = new Reflections("es.urjccode.mastercloudapps.adcs");

        try {
            Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(ControllerImplementation.class);

            for(Class<?> controllerImplementation: annotated) {
                ControllerImplementation annotation = controllerImplementation.getAnnotation(ControllerImplementation.class);
                Constructor constructor = controllerImplementation.getConstructor(Session.class, SessionImplementationDAO.class);
                AceptorController aceptorController = (AceptorController) constructor.newInstance(this.session, sessionImplementationDAO);
                this.acceptorControllers.put(annotation.value(), aceptorController);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.acceptorControllers.put(StateValue.EXIT, null);
    }

	public AceptorController getController() {
        return this.acceptorControllers.get(this.session.getValueState());
    }

}
