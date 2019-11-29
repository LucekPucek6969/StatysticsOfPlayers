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
    public String playerEdit(int id, Model model){
        Player player = playerDAO.findPlayerById(id);
        model.addAttribute("player", player);
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
        playerDAO.newPlayerID=playerDAO.createPlayer(player);
        playerDAO.newPlayer=playerDAO.findPlayerById(playerDAO.newPlayerID);
        return "redirect:/players/newPlayerView";
    }
    @GetMapping("newPlayerView")
    public String viewNewPlayer(Model model){
        Player player = playerDAO.newPlayer;
        model.addAttribute("player", player);
        playerDAO.newPlayerID=null;
        playerDAO.newPlayer=null;
        return "newPlayerView";
    }
}
