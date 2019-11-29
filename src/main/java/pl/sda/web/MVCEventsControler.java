package pl.sda.web;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.player.DAO.EventDAO;
import pl.sda.player.model.Event;
import java.util.List;


@Controller
@RequestMapping("/events")
public class MVCEventsControler {

    private EventDAO eventDAO;
    public MVCEventsControler(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    @GetMapping("viewAllEvents")
    public String viewAllEvents(Model model) {
        List<Event> events = eventDAO.findAllEvents();
        model.addAttribute("events",events);
        return "viewAllEvents";
    }
}
