package pl.sda.player.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pl.sda.player.model.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Component
public class PlayerDAO implements RowMapper<Player> {

    private JdbcTemplate jdbcTemplate;

    public PlayerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Player newPlayer=null;
    public Long newPlayerID=null;

    public List<Player> findAllPlayers() {
        String findAllPlayers = "SELECT * FROM Player";
        List<Player> players = jdbcTemplate.query(findAllPlayers, this::mapRow);
        return players;
    }

    public long createPlayer(Player player) {
        String create = "INSERT INTO " +
                "Player(NAME, SURNAME, SEX, DATEOFBIRTH,LOCATION,TEL,LICENCENUMBER) " +
                "VALUES( ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(create, new Object[]{
                player.getName(),player.getSurname(),player.getSex(),
                player.getDateOfBirth(),player.getLocation(),
                player.getTel(),player.getLicenceNumber()});
    }

    public Player findPlayerBySurname(String surname){
        String findPlayerBySurname = "SELECT * FROM PLAYER WHERE surname = ?";
        return jdbcTemplate.queryForObject(findPlayerBySurname, new Object[]{surname}, Player.class);
    }


    public Player findPlayerById(long id) {

     String findPlayerById ="SELECT * FROM PLAYER WHERE ID = ?";
     return jdbcTemplate.queryForObject(findPlayerById, new Object[]{id}, Player.class);
    }





//    public void update(int id) {
//
//    }

    @Override
    public Player mapRow(ResultSet resultSet, int i) throws SQLException {
        Player player = new Player();
        player.setId(resultSet.getLong("ID"));
        player.setName(resultSet.getString("NAME"));
        player.setSurname(resultSet.getString("SURNAME"));
        player.setSex(resultSet.getString("SEX"));
        player.setDateOfBirth(LocalDate.parse(resultSet.getString("DATEOFBIRTH")));
        player.setLocation(resultSet.getString("LOCATION"));
        player.setTel(resultSet.getString("TEL"));
        player.setLicenceNumber(resultSet.getString("LICENCENUMBER"));
        return player;
    }
}
