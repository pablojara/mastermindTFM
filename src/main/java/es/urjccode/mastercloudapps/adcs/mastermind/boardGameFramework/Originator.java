package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework;

public interface Originator {

    void restore(Memento memento) throws Exception;

    Memento createMemento() throws Exception;

}
