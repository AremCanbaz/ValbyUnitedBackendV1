package org.example.valbyunitedbackendv1.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.valbyunitedbackendv1.DTO.MatchesAndClubLogo;

import org.example.valbyunitedbackendv1.Entity.Matches;
import org.example.valbyunitedbackendv1.Entity.Pool;

import org.example.valbyunitedbackendv1.Repository.MatchRepository;
import org.example.valbyunitedbackendv1.Repository.PoolRepository;
import org.example.valbyunitedbackendv1.Service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

// Controller
@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class MatchController {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private PoolRepository poolRepository;

    @Autowired
    private MatchService matchService;

    @GetMapping("/fetch-and-save")
    public String fetchAndSaveMatches() {
        String apiKey = "https://clubservice.dbu.dk/api/TeamMatch?APIKey=b8953737-23ef-44bf-88df-91b1b90d49d9&PoolId=436205&TeamId=476538";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(apiKey, String.class);

        try {
            Map<String, Object> payload = new ObjectMapper().readValue(response.getBody(), Map.class);

            List<Map<String, Object>> matchList = (List<Map<String, Object>>) payload.get("MatchList");
            Map<String, Object> poolMap = (Map<String, Object>) payload.get("Pool");

            for (Map<String, Object> matchData : matchList) {
                Matches match = new Matches();
                match.setId(Long.valueOf(matchData.get("Id").toString()));
                match.setMatchDateTime((String) matchData.get("MatchDateTime"));
                match.setRoundNo((int) matchData.get("RoundNo"));
                match.setHomeTeamName((String) matchData.get("HomeTeamName"));
                if (matchData.get("HomeTeamScore") == null) {
                    match.setHomeTeamScore(0);

                } else {
                    match.setHomeTeamScore((int) matchData.get("HomeTeamScore"));
                }
                match.setAwayTeamName((String) matchData.get("AwayTeamName"));
                if (matchData.get("AwayTeamScore") == null) {
                    match.setAwayTeamScore(0);
                } else {
                    match.setAwayTeamScore((int) matchData.get("AwayTeamScore"));
                }
                match.setStadiumName((String) matchData.get("StadiumName"));
                System.out.println(match);
                matchRepository.save(match);
            }


            // Save Pool
            Pool pool = new Pool();
            pool.setPoolId(Long.valueOf(poolMap.get("PoolId").toString()));
            pool.setPoolName((String) poolMap.get("PoolName"));
            pool.setRowName((String) poolMap.get("RowName"));
            pool.setShowResult((boolean) poolMap.get("ShowResult"));
            pool.setShowProgram((boolean) poolMap.get("ShowProgram"));
            System.out.println(pool);
            poolRepository.save(pool);

            // Save Matches
            return "Data fetched and saved successfully!";

        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to fetch and save data: " + e.getMessage();
        }
    }

    @GetMapping("/matches")
    public List<Matches> getAllMatches() {
        List<Matches> matches = matchRepository.findAll();

        return matches;
    }

    @GetMapping("/pools")
    public List<Pool> getAllPools() {
        return poolRepository.findAll();
    }

    @GetMapping("/matcheswithlogo")
    public List<MatchesAndClubLogo> getAllClubLogos() {
        return matchService.getMatchesAndClubLogos();
    }

    @GetMapping("/upcomingmatches")
    public List<MatchesAndClubLogo> getUpcomingMatches() {
        return matchService.getupcomingMatches();
    }
    @GetMapping("/latestmatch")
    public List<MatchesAndClubLogo> getLatestMatches() {
        return matchService.getlatestMatch();
    }
}
