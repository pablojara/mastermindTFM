package es.urjccode.mastercloudapps.adcs.mastermind.models;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.memento.MementoAttribute;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProposedCombinations extends MementoAttribute implements Serializable {

    private List<ProposedCombination> proposedCombinations;


    public ProposedCombinations() {
        this.proposedCombinations = new ArrayList<ProposedCombination>();
    }

    public void add(ProposedCombination proposedCombination) {
        this.proposedCombinations.add(proposedCombination);
    }

    public ProposedCombination get(int position) {
        return this.proposedCombinations.get(position);
    }


    @Override
    public void initializeMemento(MementoAttribute mementoAttribute) {
        ProposedCombinations tmpCombinations = (ProposedCombinations) mementoAttribute;
        for(ProposedCombination tmpProp: tmpCombinations.proposedCombinations) {
            ProposedCombination newProp = new ProposedCombination();
            newProp.initializeMemento(tmpProp);
            this.proposedCombinations.add(newProp);
        }
    }
}
