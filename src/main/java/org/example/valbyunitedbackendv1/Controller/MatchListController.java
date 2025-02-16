package org.example.valbyunitedbackendv1.Controller;

import org.example.valbyunitedbackendv1.Service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MatchListController {

    @Autowired
    private MatchService matchService;


    @GetMapping("/fetch-and-save")
    public String fetchAndSaveMatches() {
        try {
            matchService.fetchAndSaveMatches();
            return "✅ Data fetched and saved successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "❌ Failed to fetch and save data.";
        }
    }
}
