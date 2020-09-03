package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.memento;

import java.util.ArrayList;

public class Registry {

    private final Originator originator;

    private int undoCount;

    private ArrayList<Memento> mementoList;

    public Registry(Originator originator) {
        this.originator = originator;
        this.undoCount = 0;
        this.mementoList = new ArrayList<>();
        try {
            this.mementoList.add(undoCount, this.originator.createMemento());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registry() {

        for (int i = 0; i < this.undoCount; i++) {
            this.mementoList.remove(0);
        }
        this.undoCount = 0;
        try {
            this.mementoList.add(this.undoCount, this.originator.createMemento());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void undo(Originator originator)  {
        this.undoCount++;
        try {
            originator.restore(this.mementoList.get(this.undoCount));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void redo(Originator originator) {
        this.undoCount--;
        System.out.println("redo!");
        try {
            originator.restore(this.mementoList.get(this.undoCount));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean undoable() {
        return this.undoCount < this.mementoList.size() - 1;
    }

    public boolean redoable() {
        return this.undoCount >= 1;
    }

    public void reset() {
        this.mementoList = new ArrayList<>();
        this.undoCount = 0;
        try {
            this.mementoList.add(undoCount, this.originator.createMemento());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
