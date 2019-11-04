package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import player.DAO.PlayerDAOimpl;
import player.model.Player;


@Controller
@RequestMapping("/mvc")
public class MVCPlayersControler {

    private final PlayerDAOimpl playerDAOimpl;

    public MVCPlayersControler(PlayerDAOimpl playerDAOimpl) {
        this.playerDAOimpl = playerDAOimpl;
    }


    @PostMapping("/addPlayer")
    public String createPlayer(Player player) {
        playerDAOimpl.createPlayer(player);
        return "redirect:/mvc/player";
    }
}
