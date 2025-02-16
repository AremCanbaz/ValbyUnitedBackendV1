package org.example.valbyunitedbackendv1.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    private Long id;
    @JsonProperty("MatchDateTime")
    private String matchDateTime;
    @JsonProperty("RoundNo")
    private int roundNo;
    @JsonProperty("HomeTeamName")
    private String homeTeamName;
    @JsonProperty("HomeTeamScore")

    private int homeTeamScore;
    @JsonProperty("AwayTeamName")
    private String awayTeamName;
    @JsonProperty("AwayTeamScore")
    private int awayTeamScore;
    @JsonProperty("StadiumName")
    private String stadiumName;

    @ManyToOne
    @JoinColumn(name = "pool_id", referencedColumnName = "id")
    private Pool pool;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMatchDateTime() {
        return matchDateTime;

    }
    public void setMatchDateTime(String matchDateTime) {
        this.matchDateTime = matchDateTime;
    }
    public int getRoundNo() {
        return roundNo;
    }
    public void setRoundNo(int roundNo) {
        this.roundNo = roundNo;
    }
    public String getHomeTeamName() {
        return homeTeamName;
    }
    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }
    public int getHomeTeamScore() {
        return homeTeamScore;
    }
    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }
    public String getAwayTeamName() {
        return awayTeamName;
    }
    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }
    public int getAwayTeamScore() {
        return awayTeamScore;
    }
    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }
    public String getStadiumName() {
        return stadiumName;
    }
    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }
    public Pool getPool() {
        return pool;
    }
    public void setPool(Pool pool) {
        this.pool = pool;
    }

    // Getters and Setters
}
