package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.util.Set;

public class BoardGame {

    protected View view;

    protected Logic logic;

    public BoardGame()  {
        this.view = new View();
    }

    public void play() {
        AceptorController acceptorController;
        do {
            acceptorController = this.logic.getController();
            if (acceptorController != null)
                this.view.interact(acceptorController);
        } while (acceptorController != null);
    }


    public static void main(String[] args) {
        Reflections reflections = new Reflections("es.urjccode.mastercloudapps.adcs");
        Set<Class<?>> executableGames = reflections.getTypesAnnotatedWith(Application.class);
        try {
            for (Class<?> executableGame : executableGames) {
                Application annotation = executableGame.getAnnotation(Application.class);
                Constructor constructor = executableGame.getConstructor();
                BoardGame gameInstance = (BoardGame) constructor.newInstance();
                gameInstance.play();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
