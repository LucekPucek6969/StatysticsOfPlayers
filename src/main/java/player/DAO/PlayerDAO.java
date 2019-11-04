package player.DAO;

import player.model.Player;

public interface PlayerDAO {

    int createPlayer(Player player);

    Player findPlayerById(int id);

    void update(int id, String name, String surname,String sex);
}
