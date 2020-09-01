package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework;

import es.urjccode.mastercloudapps.adcs.mastermind.models.SessionImplementation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SessionImplementationDAO {

    public static final String EXTENSION = ".txt";

    public static final String DIRECTORY = System.getProperty("user.dir") + "/partidas";

    private static File directory;

    static {
        SessionImplementationDAO.directory = new File(SessionImplementationDAO.DIRECTORY);
        if (!SessionImplementationDAO.directory.exists()) {
            SessionImplementationDAO.directory.mkdir();
        }
    }

    private final SessionImplementation sessionImplementation;

    private final GameDAO gameDAO;

    public SessionImplementationDAO(SessionImplementation sessionImplementation) {
        this.sessionImplementation = sessionImplementation;
        this.gameDAO = new GameDAO(sessionImplementation.getGame());
        System.out.println(sessionImplementation.getGame().hashCode() + "gameHashCode");
    }

    public void save() {
        this.save(this.sessionImplementation.getName());
    }

    public void save(String name) {
        if (!name.endsWith(SessionImplementationDAO.EXTENSION)) {
            name = name + SessionImplementationDAO.EXTENSION;
        }
        File file = new File(SessionImplementationDAO.directory, name);
        try {
            FileWriter fileWriter = new FileWriter(file);
            this.gameDAO.save();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String name) {
        this.sessionImplementation.setName(name);
        this.gameDAO.load();
        this.sessionImplementation.resetRegistry();
        this.sessionImplementation.setStateValue(StateValue.IN_GAME);
        if (this.sessionImplementation.isBlocked()) {
            this.sessionImplementation.setStateValue(StateValue.FINAL);
        }
    }

    public String[] getGamesNames() {
        return SessionImplementationDAO.directory.list();
    }

    public boolean exists(String name) {
        for (String auxName : this.getGamesNames()) {
            if (auxName.equals(name + SessionImplementationDAO.EXTENSION)) {
                return true;
            }
        }
        return false;
    }
}
