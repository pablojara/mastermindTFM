package es.urjccode.mastercloudapps.adcs.mastermind.models;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.DAO.DAOField;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.memento.MementoField;
import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.models.Game;
import es.urjccode.mastercloudapps.adcs.mastermind.types.Color;

import java.util.ArrayList;
import java.util.List;

public class GameImplementation extends Game {

    private static final int MAX_LONG = 10;

    @DAOField("secretCombination")
    @MementoField("secretCombination")
    private SecretCombination secretCombination;

    @DAOField("proposedCombinations")
    @MementoField("proposedCombinations")
    private ProposedCombinations proposedCombinations;

    @DAOField("results")
    @MementoField("results")
    private Results results;

    @DAOField("attempts")
    @MementoField("attempts")
    private Attempts attempts;

    public GameImplementation() {
        this.secretCombination = new SecretCombination();
        this.attempts = new Attempts();
        this.clear();
    }

    void clear() {
        this.proposedCombinations = new ProposedCombinations();
        this.results = new Results();
        this.attempts.attempts = 0;
    }

    void addProposedCombination(List<Color> colors) {
        ProposedCombination proposedCombination = new ProposedCombination(colors);
        this.proposedCombinations.add(proposedCombination);
        this.results.add(this.secretCombination.getResult(proposedCombination));
        this.attempts.attempts++;
    }

    @Override
    public void reset() {

    }

    @Override
    public void cancel() {

    }

    public void setAttempts(int attempts) {
        this.attempts.attempts = attempts;
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.proposedCombinations.add(proposedCombination);
    }

    public void addResult(Result result) {
        this.results.add(result);
    }

    boolean isLooser() {
        return this.attempts.attempts == GameImplementation.MAX_LONG;
    }

    boolean isWinner() {
        if (this.attempts.attempts == 0) {
            return false;
        }
        return this.results.get(this.attempts.attempts - 1).isWinner();
    }

    int getWidth() {
        return Combination.getWidth();
    }

    public int getAttempts() {
        return this.attempts.attempts;
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
