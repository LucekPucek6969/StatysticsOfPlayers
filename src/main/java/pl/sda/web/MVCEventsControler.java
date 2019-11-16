package pl.sda.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.player.DAO.EventDAO;


@Controller
@RequestMapping("/player")

public class MVCEventsControler {

    private EventDAO eventDAO;

    @GetMapping("/viewAllEvents")
    public String viewAllEvents(Model model) {
//        List<Player> players = eventDAO.findAllEvents();
//        model.addAttribute("events",events);
        return "viewAllEvents";
    }
}
