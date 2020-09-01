package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Set;

public class View implements ControllerVisitor {

    private HashMap<StateValue, SubView> annotatedViewsMap;

    public View() {

        this.annotatedViewsMap = new HashMap<StateValue, SubView>();

        Reflections reflections = new Reflections("es.urjccode.mastercloudapps.adcs");
        Set<Class<?>> annotatedViews = reflections.getTypesAnnotatedWith(SubViewImplementation.class);

        try {

            for (Class<?> subViewClass : annotatedViews) {
                SubViewImplementation annotation = subViewClass.getAnnotation(SubViewImplementation.class);
                Constructor constructor = subViewClass.getConstructor();
                SubView subViewInstance = (SubView) constructor.newInstance();
                annotatedViewsMap.put(annotation.value(), subViewInstance);
            }
        } catch (Exception e) {
        e.printStackTrace();
        }

    }

    public void interact(AceptorController controller) {
        assert controller != null;
        controller.accept(this);
    }

    @Override
    public void visit(AceptorController aceptorController)  {
        Class<?> controllerClass = aceptorController.getClass();
        ControllerImplementation annotation = controllerClass.getAnnotation(ControllerImplementation.class);
        SubView matchingView = this.annotatedViewsMap.get(annotation.value());
        matchingView.interact(aceptorController);
    }
}
