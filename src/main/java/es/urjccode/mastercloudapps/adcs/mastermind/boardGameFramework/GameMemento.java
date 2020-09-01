package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework;


import java.util.HashMap;

public class GameMemento extends Memento {

    HashMap<String, Object> mementoFields;

    public GameMemento() {
    }

    public void setMemento(HashMap<String, Object> mementoFields){
        this.mementoFields = mementoFields;
    }

    public HashMap<String, Object> getMemento(){
        return this.mementoFields;
    }

}
