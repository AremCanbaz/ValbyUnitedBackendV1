package org.example.valbyunitedbackendv1.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.valbyunitedbackendv1.DTO.MatchListResponse;
import org.example.valbyunitedbackendv1.Entity.Pool;
import org.example.valbyunitedbackendv1.Entity.Match;
import org.example.valbyunitedbackendv1.Repository.MatchRepository;
import org.example.valbyunitedbackendv1.Repository.PoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private PoolRepository poolRepository;

    private final String API_URL = "https://clubservice.dbu.dk/api/TeamMatch?APIKey=b8953737-23ef-44bf-88df-91b1b90d49d9&PoolId=436205&TeamId=476538";

    public void fetchAndSaveMatches() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            String responseStr = restTemplate.getForObject(API_URL, String.class);
            System.out.println("API Response: " + responseStr);

            ObjectMapper objectMapper = new ObjectMapper();
            MatchListResponse response = objectMapper.readValue(responseStr, MatchListResponse.class);

            // Validate and save pool
            Pool pool = response.getPool();
            if (pool != null) {
                Pool savedPool = poolRepository.save(pool);

                // Validate and save matches
                List<Match> matches = response.getMatchList();
                if (matches != null) {
                    for (Match match : matches) {
                        if (match != null) {
                            match.setPool(savedPool);
                            matchRepository.save(match);
                        } else {
                            System.err.println("Encountered a null match, skipping...");
                        }
                    }
                } else {
                    System.err.println("Match list is null or empty.");
                }
            } else {
                System.err.println("Pool is null, nothing to save.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to fetch or save matches.");
        }
    }
}

