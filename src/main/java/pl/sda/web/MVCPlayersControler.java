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

public class MVCPlayersControler {

    private PlayerDAO playerDAO;

    public MVCPlayersControler(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    @RequestMapping("/")
    public String start() {
        return "index";
    }

    @RequestMapping("/playerForm")
    public String viewPlayer(){
        return "playerForm";
    }

//    @RequestMapping("/addPlayerForm")
//    public String viewAddPlayer(Model model){
//     model.addAttribute("addNewPayer",player);
//        return "addPlayerForm";
//    }



    @PostMapping("/addNewPlayer")
    public String createPlayer(Player player) {
        playerDAO.createPlayer(player);
        Model model=null;
        model.addAttribute("player",player);

        return "redirect:addPlayerView";
            }



    @GetMapping("/viewAllPlayers")
     public String viewAllPlayers(Model model){
        List<Player> players = playerDAO.findAllPlayers();
        model.addAttribute("players",players);
        return "viewAllPlayers";
    }
}
