package pl.sda.player.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pl.sda.player.model.Player;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class PlayerDAO implements RowMapper<Player> {

    private JdbcTemplate jdbcTemplate;

    public PlayerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int createPlayer(Player player) {
        String create = "INSERT INTO Player(name,surname,sex) VALUES( ?, ?, ?)";
        return jdbcTemplate.update(create, new Object[]{
                player.getName(),player.getSurname(),player.getSex() });
    }

    public Player findPlayerBySurname(String surname){
        String findPlayerBySurname = "SELECT * FROM PLAYER WHERE surname = ?";
        return jdbcTemplate.queryForObject(findPlayerBySurname, new Object[]{surname}, Player.class);
    }


    public Player findPlayerById(int id) {

     String findPlayerById ="SELECT * FROM PLAYER WHERE ID = ?";
     return jdbcTemplate.queryForObject(findPlayerById, new Object[]{id}, Player.class);
    }


    public List<Player> findAllPlayers() {

        String findAllPlayers = "SELECT * FROM Player";
        List<Player> players = jdbcTemplate.query(findAllPlayers, this::mapRow);
        return players;
    }


//    public void update(int id, String name, String surname,String sex) {
//
//    }

    @Override
    public Player mapRow(ResultSet resultSet, int i) throws SQLException {
        Player player = new Player();
        player.setId(resultSet.getInt("ID"));
        player.setName(resultSet.getString("NAME"));
        player.setSurname(resultSet.getString("SURNAME"));
        player.setSex(resultSet.getString("SEX"));
        return player;
    }
}
