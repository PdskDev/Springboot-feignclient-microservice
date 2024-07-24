package me.nadetdev.albums.client;

import me.nadetdev.albums.models.Player;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "player", url = "http://localhost:8080")
public interface PlayerClient {

    @RequestMapping(method = RequestMethod.GET, value = "/players")
    List<Player> fromMicroserviceGetListOfPlayers();
}
