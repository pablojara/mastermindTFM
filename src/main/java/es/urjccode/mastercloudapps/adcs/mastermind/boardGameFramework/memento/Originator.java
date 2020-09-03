package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.memento;

public interface Originator {

    void restore(Memento memento) throws Exception;

    Memento createMemento() throws Exception;

}
