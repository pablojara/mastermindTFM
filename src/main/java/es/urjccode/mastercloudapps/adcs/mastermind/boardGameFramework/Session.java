package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework;


public class Session {

    protected State state;
    protected Registry registry;
    protected Game game;
    protected String name;

    public Session(Game game) {
        this.game = game;
        this.state = new State();
        this.registry = new Registry(this.game);
        this.name = null;
    }
    public Session(Game game, State state) {
        this.game = game;
        this.state = state;
    }
    public void resetGame() { this.game.reset();}
    public void resetState() {this.state.reset();}
    public void resume() {
        this.game.reset();
        this.state.reset();
        this.name = null;
    }
    public StateValue getValueState() {
        return this.state.getValueState();
    }
    public void setStateValue(StateValue value) {
        this.state.setStateValue(value);
    }
    public boolean isBlocked() {
        return this.game.isBlocked();
    }
    public void resetRegistry() {
        this.registry.reset();
    }
    public Game getGame() {
        return this.game;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void next() {
        this.state.next();
    }

    public boolean undoable() {
        return this.registry.undoable();
    }

    public boolean redoable() {
        return this.registry.redoable();
    }

    public void undo() {
        this.registry.undo(this.game);
    }

    public void redo() {
        this.registry.redo(this.game);
    }

    public void cancel() {
        this.game.cancel();
    }
    public boolean hasName() {
        return this.name != null;
    }


}
