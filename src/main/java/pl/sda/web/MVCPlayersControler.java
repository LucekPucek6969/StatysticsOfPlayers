package pl.sda.web;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.player.DAO.PlayerDAO;
import pl.sda.player.model.Player;
import java.util.List;


@Controller
@RequestMapping("/player")
public class MVCPlayersControler {

    private PlayerDAO playerDAO;

    @GetMapping("/start")
    public String start() {
        return "start";
    }

    @GetMapping("/createPlayer")
    public String getCreatePlayer() {
        return "createPlayer";
    }

    @PostMapping("/createPlayer")
    public String createPlayer(Player player) {
        playerDAO.createPlayer(player);
        return "redirect:viewAllPlayers";
    }

    @GetMapping("/viewAllPlayers")
     public String viewAllPlayers(Model model){
        List<Player> players = playerDAO.findAllPlayers();
        model.addAttribute("players",players);
        return "viewAllPlayers";
    }
}
