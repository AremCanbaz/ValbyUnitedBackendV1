package org.example.valbyunitedbackendv1.Controller;

import org.example.valbyunitedbackendv1.Service.MatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/matches")
public class MatchesController {

    @Autowired
    private MatchesService matchesService;

    @PostMapping("/fetch-and-save")
    public ResponseEntity<String> fetchAndSaveMatches() {
        try {
            matchesService.fetchAndSaveMatches();
            return ResponseEntity.ok("Matches fetched and saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching and saving matches: " + e.getMessage());
        }
    }
}

