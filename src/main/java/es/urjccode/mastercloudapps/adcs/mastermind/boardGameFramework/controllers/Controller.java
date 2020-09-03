package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.controllers;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.models.Session;

public abstract class Controller {

    protected Session session;

    public Controller(Session session) {
        this.session = session;
    }

    public Session getSession(){
        return this.session;
    }
}
