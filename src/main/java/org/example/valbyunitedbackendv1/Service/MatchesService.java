package org.example.valbyunitedbackendv1.Service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.example.valbyunitedbackendv1.Entity.Matches;
import org.example.valbyunitedbackendv1.Repository.MatchesRepository;
import org.example.valbyunitedbackendv1.DTO.TeamMatchProgram;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@Service
public class MatchesService {

    private final MatchesRepository matchesRepository;
    private final RestTemplate restTemplate;

    public MatchesService(MatchesRepository matchesRepository) {
        this.matchesRepository = matchesRepository;
        this.restTemplate = new RestTemplate();
    }

    public void fetchAndSaveMatches() {
        try {
            // Bygger HTTP-anmodning med Accept-header sat til JSON
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", "application/json");
            HttpEntity<String> entity = new HttpEntity<>(headers);

            // Sender anmodningen
            String apiUrl = "https://clubservice.dbu.dk/api/TeamMatch?APIKey=b8953737-23ef-44bf-88df-91b1b90d49d9&PoolId=436205&TeamId=476538";
            ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);

            // Parser JSON-svaret
            String json = response.getBody();
            ObjectMapper objectMapper = new ObjectMapper();
            TeamMatchProgram teamMatchProgram = objectMapper.readValue(json, TeamMatchProgram.class);

            // Gemmer matchene i databasen
            matchesRepository.deleteAll();
            List<Matches> matches = (List<Matches>) teamMatchProgram.getMatchList();
            matches.forEach(matchesRepository::save);

            System.out.println("Successfully saved " + matches.size() + " matches.");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to fetch or save matches: " + e.getMessage());
        }
    }
}
