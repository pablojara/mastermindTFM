package es.urjccode.mastercloudapps.adcs.mastermind.models;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.memento.MementoAttribute;

import java.io.Serializable;

public class Attempts extends MementoAttribute implements Serializable {

    public int attempts;

    public Attempts(){
        this.attempts = 0;
    }

    @Override
    public void initializeMemento(MementoAttribute mementoAttribute) {
        Attempts tmpAtt = (Attempts) mementoAttribute;
        this.attempts = tmpAtt.attempts;
    }
}
