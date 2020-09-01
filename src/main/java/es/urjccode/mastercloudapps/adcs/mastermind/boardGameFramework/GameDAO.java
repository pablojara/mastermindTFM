package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework;


class GameDAO implements DAO {

    private Game game;

    GameDAO(Game game) {
        this.game = game;
    }

    @Override
    public void save() {
        try {
            System.out.println(this.game.hashCode() + "gameDAO game hashCode preSave");
            DAOSerializer.serialize(this.game);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
        try {
            this.game = (Game)DAOSerializer.deserialize(this.game);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
