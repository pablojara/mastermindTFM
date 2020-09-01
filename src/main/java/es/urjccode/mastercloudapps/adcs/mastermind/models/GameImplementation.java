package es.urjccode.mastercloudapps.adcs.mastermind.models;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.DAOField;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.Game;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MementoField;
import es.urjccode.mastercloudapps.adcs.mastermind.types.Color;

import java.util.ArrayList;
import java.util.List;

public class GameImplementation extends Game {

    private static final int MAX_LONG = 10;

    @DAOField("secretCombination")
    //@MementoField("secretCombination")
    private SecretCombination secretCombination;

    @DAOField("proposedCombinations")
    //@MementoField("proposedCombinations")
    private List<ProposedCombination> proposedCombinations;

    @DAOField("results")
    //@MementoField("results")
    private List<Result> results;

    @DAOField("attempts")
    //@MementoField("attempts")
    private int attempts;

    public GameImplementation() {
        this.secretCombination = new SecretCombination();
        this.clear();
    }

    void clear() {
        this.proposedCombinations = new ArrayList<ProposedCombination>();
        this.results = new ArrayList<Result>();
        this.attempts = 0;
    }

    void addProposedCombination(List<Color> colors) {
        ProposedCombination proposedCombination = new ProposedCombination(colors);
        this.proposedCombinations.add(proposedCombination);
        this.results.add(this.secretCombination.getResult(proposedCombination));
        this.attempts++;
    }

    @Override
    public void reset() {

    }

    @Override
    public void cancel() {

    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.proposedCombinations.add(proposedCombination);
    }

    public void addResult(Result result) {
        this.results.add(result);
    }

    boolean isLooser() {
        return this.attempts == GameImplementation.MAX_LONG;
    }

    boolean isWinner() {
        if (this.attempts == 0) {
            return false;
        }
        return this.results.get(this.attempts - 1).isWinner();
    }

    int getWidth() {
        return Combination.getWidth();
    }

    public int getAttempts() {
        return this.attempts;
    }

    List<Color> getColors(int position) {
        return this.proposedCombinations.get(position).colors;
    }

    int getBlacks(int position) {
        return this.results.get(position).getBlacks();
    }

    int getWhites(int position) {
        return this.results.get(position).getWhites();
    }

    public SecretCombination getSecretCombination() {
        return this.secretCombination;
    }

    public ProposedCombination getProposedCombination(int position) {
        return this.proposedCombinations.get(position);
    }

    public Result getResult(int position) {
        return this.results.get(position);
    }

    @Override
    public String toString() {
        return "Game [secretCombination=" + secretCombination + ", proposedCombinations=" + proposedCombinations
                + ", results=" + results + ", attempts=" + attempts + "]";
    }


}
