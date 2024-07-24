package me.nadetdev.albums.service;

import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate;
import me.nadetdev.albums.models.Player;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    private RestClient restClient;

    public PlayerService(RestClient restClient) {
        this.restClient = restClient;
    }


    public List<Player> getPlayers() {
        return restClient.get().uri("/players").retrieve()
                .body(new ParameterizedTypeReference<List<Player>>() {
                });
    }

    public Optional<Player> getPlayerById(String id) {
        return restClient.get().uri("players/{id}", id)
                .exchange((request, response) -> {
                    if(response.getStatusCode().equals(HttpStatus.NOT_FOUND)){
                        return Optional.empty();
                    }
                    return Optional.of(response.bodyTo(Player.class));
        });
    }
}
