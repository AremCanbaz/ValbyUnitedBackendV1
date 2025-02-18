package org.example.valbyunitedbackendv1.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Matches {
    @Id
    //@JsonProperty(namespace = "Id")
    //@Column(name = "Id")
    private Long id;
    //@Column(name = "MatchDateTime")
    //@JsonProperty(namespace = "MatchDateTime")
    private String matchDateTime;
    //@Column(name = "RoundNo")
    //@JsonProperty(namespace = "RoundNo")
    private int roundNo;
    //@Column(name = "HomeTeamName")
    //@JsonProperty(namespace = "HomeTeamName")
    private String homeTeamName;
    //@Column(name = "HomeTeamScore")
    //@JsonProperty(namespace = "HomeTeamScore")
    private int homeTeamScore;
    //@Column(name = "AwayTeamName")
    //@JsonProperty(namespace = "AwayTeamName")
    private String awayTeamName;
    //@Column(name = "AwayTeamScore")
    //@JsonProperty(namespace = "AwayTeamScore")
    private int awayTeamScore;
    //@Column(name = "StadiumName")
    //@JsonProperty(namespace = "StadiumName")
    private String stadiumName;

    public Matches() {}
    public Matches(long id, String matchDateTime,int roundNo,String homeTeamName, int homeTeamScore, String awayTeamName, int awayTeamScore, String stadiumName, String homeTeamLogo, String awayTeamLogo) {
    }
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getMatchDateTime() { return matchDateTime; }
    public void setMatchDateTime(String matchDateTime) { this.matchDateTime = matchDateTime; }
    public int getRoundNo() { return roundNo; }
    public void setRoundNo(int roundNo) { this.roundNo = roundNo; }
    public String getHomeTeamName() { return homeTeamName; }
    public void setHomeTeamName(String homeTeamName) { this.homeTeamName = homeTeamName; }
    public int getHomeTeamScore() { return homeTeamScore; }
    public void setHomeTeamScore(int homeTeamScore) { this.homeTeamScore = homeTeamScore; }
    public String getAwayTeamName() { return awayTeamName; }
    public void setAwayTeamName(String awayTeamName) { this.awayTeamName = awayTeamName; }
    public int getAwayTeamScore() { return awayTeamScore; }
    public void setAwayTeamScore(int awayTeamScore) { this.awayTeamScore = awayTeamScore; }
    public String getStadiumName() { return stadiumName; }

    public void setStadiumName(String stadiumName) { this.stadiumName = stadiumName; }

    @Override
    public String toString() {
        return "Matches{" +
                "id=" + id +
                ", matchDateTime='" + matchDateTime + '\'' +
                ", roundNo=" + roundNo +
                ", homeTeamName='" + homeTeamName + '\'' +
                ", homeTeamScore=" + homeTeamScore +
                ", awayTeamName='" + awayTeamName + '\'' +
                ", awayTeamScore=" + awayTeamScore +
                ", stadiumName='" + stadiumName + '\'' +
                '}';
    }
}

