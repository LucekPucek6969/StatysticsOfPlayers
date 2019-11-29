package pl.sda.player.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pl.sda.player.model.Event;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Component
public class EventDAO implements RowMapper<Event>{

    private JdbcTemplate jdbcTemplate;
    public EventDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

        public List<Event> findAllEvents() {
            String findAllEventsQuerry = "SELECT * FROM EVENT";
            List<Event> events = jdbcTemplate.query(findAllEventsQuerry,this::mapRow);
            return events;
        }
        
//    public List<Event> findAllEvents() {
//        throw new UnsupportedOperationException("Implement this method");
//        String findAllPlayers = "SELECT * FROM Event";
//        List<Player> events = jdbcTemplate.query(findAllPlayers, this::mapRow);
//        return events;
//
//    }
    @Override
    public Event mapRow(ResultSet resultSet, int i) throws SQLException {
        Event event = new Event();
        event.setId(resultSet.getInt("ID"));
        event.setName(resultSet.getString("NAME"));
        event.setDescription(resultSet.getString("DESCRIPTION"));
        event.setEventDate(LocalDate.parse(resultSet.getString("EVENTDATE")));
        return event;
    }
}
