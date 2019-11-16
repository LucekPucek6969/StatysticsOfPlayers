package pl.sda.player.DAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import pl.sda.player.model.Event;
import pl.sda.player.model.Player;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EventDAO implements RowMapper{


    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Event event = new Event();
        event.setId(resultSet.getInt("ID"));
        event.setName(resultSet.getString("NAME"));
        event.setDescription(resultSet.getString("DESCRIPTION"));
        event.setDate(resultSet.getString("DATE"));
        return event;

    }

    public List<Event> findAllEvents() {
        throw new UnsupportedOperationException("Implement this method");
    }
}
