package org.example.valbyunitedbackendv1.Repository;

import org.example.valbyunitedbackendv1.DTO.MatchesAndClubLogo;
import org.example.valbyunitedbackendv1.Entity.Matches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Objects;

public interface MatchRepository extends JpaRepository<Matches, Long> {
    @Query(value = "SELECT m.id AS matchId, \n" +
            "       m.match_date_time AS matchDateTime, \n" +
            "       m.round_no AS roundNo,\n" +
            "       m.home_team_name AS homeTeamName, \n" +
            "       h.logo_url AS homeTeamLogo, \n" +
            "       m.home_team_score AS homeTeamScore,\n" +
            "       m.away_team_name AS awayTeamName, \n" +
            "       a.logo_url AS awayTeamLogo, \n" +
            "       m.away_team_score AS awayTeamScore,\n" +
            "       m.stadium_name AS stadiumName\n" +
            "FROM matches m\n" +
            "JOIN club_logo h ON m.home_team_name = h.club_name\n" +
            "JOIN club_logo a ON m.away_team_name = a.club_name\n" +
            "WHERE m.match_date_time > CURRENT_TIMESTAMP\n" +
            "ORDER BY m.match_date_time ASC;", nativeQuery = true)
    List<Object[]> upcomingMatches();


}
