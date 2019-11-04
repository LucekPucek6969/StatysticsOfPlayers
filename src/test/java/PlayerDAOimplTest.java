import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import player.model.Player;
import player.DAO.PlayerDAO;
import player.DAO.PlayerDAOimpl;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerDAOimplTest {

    @DisplayName("given player (Jagna, Strzelba, female), when add Jagna to Table player.model.Player," +
            " then Jagna will to be in Base player.model.Player")
    @Test
    void assignaddPlayerTest() {
        // given
        Player player = new Player(22,"Jagna","Strzelba","female");
        PlayerDAO playerDAO= new PlayerDAOimpl();

        // when
        playerDAO.createPlayer(player);

        // then
        Player playerFromDao = playerDAO.findPlayerById(22);

    }

}