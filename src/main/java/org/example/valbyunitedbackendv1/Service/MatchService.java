package org.example.valbyunitedbackendv1.Service;

import org.example.valbyunitedbackendv1.DTO.MatchesAndClubLogo;
import org.example.valbyunitedbackendv1.Entity.ClubLogo;
import org.example.valbyunitedbackendv1.Entity.Matches;
import org.example.valbyunitedbackendv1.Repository.ClubLogoRepository;
import org.example.valbyunitedbackendv1.Repository.MatchRepository;
import org.example.valbyunitedbackendv1.Repository.PoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private PoolRepository poolRepository;

    @Autowired
    private ClubLogoRepository clubLogoRepository;

    public List<MatchesAndClubLogo> getMatchesAndClubLogos() {
        List<MatchesAndClubLogo> matchesAndClubLogos = new ArrayList<>();
        List<Matches> matches = matchRepository.findAll();

        for (Matches match : matches) {
            String clubLogoHome =  clubLogoRepository.findLogoUrlByClubName(match.getHomeTeamName());
            String clubLogoAway =  clubLogoRepository.findLogoUrlByClubName(match.getAwayTeamName());

            MatchesAndClubLogo matchesAndClubLogoObj = new MatchesAndClubLogo(match.getId(),match.getMatchDateTime(), match.getRoundNo(),match.getHomeTeamName(),clubLogoHome,match.getHomeTeamScore(),match.getAwayTeamName(),clubLogoAway,match.getAwayTeamScore(),match.getStadiumName());
            matchesAndClubLogos.add(matchesAndClubLogoObj);
        }
        return matchesAndClubLogos;
    }
    public List<MatchesAndClubLogo> getupcomingMatches() {
            List<Object[]> results = matchRepository.upcomingMatches();
            List<MatchesAndClubLogo> upcomingMatches = new ArrayList<>();

            for (Object[] result : results) {
                Long matchId = (Long) result[0];
                String matchDateTime = (String) result[1];
                int roundNo = (int) result[2];
                String homeTeamName = (String) result[3];
                String homeTeamLogo = (String) result[4];
                int homeTeamScore = (int) result[5];
                String awayTeamName = (String) result[6];
                String awayTeamLogo = (String) result[7];
                int awayTeamScore = (int) result[8];
                String stadiumName = (String) result[9];

                MatchesAndClubLogo match = new MatchesAndClubLogo(matchId, matchDateTime, roundNo, homeTeamName, homeTeamLogo,
                        homeTeamScore, awayTeamName, awayTeamLogo, awayTeamScore, stadiumName);
                upcomingMatches.add(match);
            }

            return upcomingMatches;
        }
    }



