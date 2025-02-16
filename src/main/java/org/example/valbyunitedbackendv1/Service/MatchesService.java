package org.example.valbyunitedbackendv1.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.valbyunitedbackendv1.DTO.TeamMatchProgram;
import org.example.valbyunitedbackendv1.Entity.Matches;
import org.example.valbyunitedbackendv1.Repository.MatchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MatchesService {

    @Autowired
    private MatchesRepository matchesRepository;

    @Value("https://clubservice.dbu.dk/api/TeamMatch?APIKey=b8953737-23ef-44bf-88df-91b1b90d49d9&PoolId=436205&TeamId=476538")
    private String apiUrl;

    public void fetchAndSaveMatches() throws Exception {
        // Hent XML fra URL
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, String.class);

        // Parse XML
        String xml = response.getBody();
        ObjectMapper objectMapper = new XmlMapper();
        TeamMatchProgram teamMatchProgram = objectMapper.readValue(xml, TeamMatchProgram.class);

        // Gem matchene i databasen
        for (Matches match : teamMatchProgram.getMatchList().getMatches()) {
            matchesRepository.save(match);
        }
    }
}

