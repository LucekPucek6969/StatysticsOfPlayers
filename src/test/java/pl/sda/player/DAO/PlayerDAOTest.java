package pl.sda.player.DAO;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.sda.player.model.Player;

import static org.junit.jupiter.api.Assertions.*;

class PlayerDAOTest {

    @DisplayName("given pl.sda.player (Jagna, Strzelba, female), when add Jagna to Table pl.sda.player.model.Player," +
            " then Jagna will to be in Base pl.sda.player.model.Player")
    @Test
    void createPlayerTest() {
        // given
        Player player = new Player(22, "Jagna", "Strzelba", "female");
        PlayerDAO playerDAO = new PlayerDAO(null);

        // when
        playerDAO.createPlayer(player);

        // then
        Player playerFromDao = playerDAO.findPlayerById(22);
    }

    @DisplayName("get all player and check List<Player> is not empty")
    void findAllPlayersTest(){
        //given

        //when


        //then


    }
}