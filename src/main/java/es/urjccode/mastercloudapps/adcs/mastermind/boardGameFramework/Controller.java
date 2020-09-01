package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework;

public abstract class Controller {

    protected Session session;

    public Controller(Session session) {
        this.session = session;
    }

    public Session getSession(){
        return this.session;
    }
}
