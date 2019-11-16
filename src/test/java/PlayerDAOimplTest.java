import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.sda.player.model.Player;
import pl.sda.player.DAO.PlayerDAO;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerDAOimplTest {

    @DisplayName("given pl.sda.player (Jagna, Strzelba, female), when add Jagna to Table pl.sda.player.model.Player," +
            " then Jagna will to be in Base pl.sda.player.model.Player")
    @Test
    void assignaddPlayerTest() {
        // given
        Player player = new Player(22,"Jagna","Strzelba","female");
        PlayerDAO playerDAO= new PlayerDAO();

        // when
        playerDAO.createPlayer(player);

        // then
        Player playerFromDao = playerDAO.findPlayerById(22);

    }

}