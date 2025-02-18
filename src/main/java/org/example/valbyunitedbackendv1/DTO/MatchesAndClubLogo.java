package org.example.valbyunitedbackendv1.DTO;

public class MatchesAndClubLogo {
    private Long id;
    private String matchDateTime;

    public MatchesAndClubLogo(Long matchId, String matchDateTime, int roundNo, String homeTeamName, String homeTeamLogo, int homeTeamScore, String awayTeamName, String awayTeamLogoUrl, int awayTeamScore, String stadiumName) {
        this.id = matchId;
        this.matchDateTime = matchDateTime;
        this.roundNo = roundNo;
        this.homeTeamName = homeTeamName;
        this.homeTeamLogo = homeTeamLogo;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamName = awayTeamName;
        this.awayTeamLogo = awayTeamLogoUrl;
        this.awayTeamScore = awayTeamScore;
        this.stadiumName = stadiumName;
    }
    public int getRoundNo() {
        return roundNo;
    }

    public void setRoundNo(int roundNo) {
        this.roundNo = roundNo;
    }

    private int roundNo;
    private String homeTeamName;

    public String getHomeTeamLogo() {
        return homeTeamLogo;
    }

    public void setHomeTeamLogo(String homeTeamLogo) {
        this.homeTeamLogo = homeTeamLogo;
    }

    private String homeTeamLogo;

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    private int homeTeamScore;

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    private String awayTeamName;

    public String getAwayTeamLogo() {
        return awayTeamLogo;
    }

    public void setAwayTeamLogo(String awayTeamLogo) {
        this.awayTeamLogo = awayTeamLogo;
    }

    private String awayTeamLogo;

    public String getMatchDateTime() {
        return matchDateTime;
    }

    public void setMatchDateTime(String matchDateTime) {
        this.matchDateTime = matchDateTime;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    private int awayTeamScore;
    private String stadiumName;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }
}
