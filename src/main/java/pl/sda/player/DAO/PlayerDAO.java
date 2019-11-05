package pl.sda.player.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import pl.sda.player.model.Player;

import javax.sql.DataSource;
import java.util.List;

public class PlayerDAOimpl implements PlayerDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;


    public void setDataSource(DataSource dataSource) {

        this.dataSource=dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);

    }

    @Override
    public int createPlayer(Player player) {
        String create = "INSERT INTO Player(name,surname,sex) VALUES( ?, ?, ?)";
        return jdbcTemplate.update(create, new Object[]{
                player.getName(),player.getSurname(),player.getSex() });
    }



    @Override
    public Player findPlayerById(int id) {
     String findById ="SELECT * FROM pl.sda.player.model.Player WHERE ID =:id";
        return null;
    }

    @Override
    public List<Player> findAllPlayers() {
        return null;
    }




    @Override
    public void update(int id, String name, String surname,String sex) {

    }
}
