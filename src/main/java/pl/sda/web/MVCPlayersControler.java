package pl.sda.web;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.player.DAO.PlayerDAO;
import pl.sda.player.model.Player;
import java.util.List;


@Controller
@RequestMapping("/players")
public class MVCPlayersControler {

    private PlayerDAO playerDAO;

    public MVCPlayersControler(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    @GetMapping("start")
    public String start() {
        return "start";
    }

    @GetMapping("playerView")
    public String viewPlayer(Player player,Model model){
        player=playerDAO.newPlayer;
        model.addAttribute("player",player);
        playerDAO.newPlayer=null;
        return "playerView";
    }


    @GetMapping("viewAllPlayers")
    public String viewAllPlayers(Model model){
        List<Player> players = playerDAO.findAllPlayers();
        model.addAttribute("players",players);
        return "viewAllPlayers";
    }
    @PostMapping("viewAllPlayers")
    public String createPlayer(Player player){
        playerDAO.createPlayer(player);
        playerDAO.newPlayer=player;
        return "redirect:/players/playerView";
            }

}
