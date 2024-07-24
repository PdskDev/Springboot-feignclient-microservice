package me.nadetdev.albums.controller;

import me.nadetdev.albums.client.PlayerClient;
import me.nadetdev.albums.models.Player;
import me.nadetdev.albums.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

    private final PlayerClient playerClient;

    @Autowired
    private PlayerService playerService;

    public AlbumsController(PlayerClient playerClient) {
        this.playerClient = playerClient;
    }

    @GetMapping("/players")
    public List<Player> getPlayers(){
        return playerClient.fromMicroserviceGetListOfPlayers();
    }

    @GetMapping("/players-client")
    public List<Player> getPlayersWithClient(){
        return playerService.getPlayers();
    }

    @GetMapping("/players-client/{id}")
    public Optional<Player> getPlayerByIbWithClient(@PathVariable("id") String id) {
        return playerService.getPlayerById(id);
    }

}
