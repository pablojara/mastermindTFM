package es.urjccode.mastercloudapps.adcs.mastermind.models;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.memento.MementoAttribute;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Results extends MementoAttribute implements Serializable {

    private List<Result> results;

    public Results() {
        this.results = new ArrayList<Result>();
    }

    public void add(Result result) {
        this.results.add(result);
    }

    public Result get(int n){
        return this.results.get(n);
    }

    @Override
    public void initializeMemento(MementoAttribute mementoAttribute) {
        Results tmpResults = (Results) mementoAttribute;
        for(Result tmpRes :tmpResults.results) {
            Result newRes = new Result();
            newRes.initializeMemento(tmpRes);
            this.results.add(newRes);
        }
    }
}
