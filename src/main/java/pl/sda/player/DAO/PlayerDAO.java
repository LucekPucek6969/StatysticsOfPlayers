package pl.sda.player.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import pl.sda.player.model.Player;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PlayerDAO implements RowMapper<Player> {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;


    public void setDataSource(DataSource dataSource) {

        this.dataSource=dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);

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

        String findAllPlayers = "SELECT * FROM PLAYER";
        List<Player> players = jdbcTemplate.query(findAllPlayers, new PlayerDAO());
        return players;
    }


    public void update(int id, String name, String surname,String sex) {

    }

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
