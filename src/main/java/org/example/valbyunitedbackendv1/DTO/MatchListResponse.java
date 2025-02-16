package org.example.valbyunitedbackendv1.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.valbyunitedbackendv1.Entity.Match;
import org.example.valbyunitedbackendv1.Entity.Pool;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchListResponse {

    @JsonProperty("MatchList")
    private List<Match> matchList;

    @JsonProperty("Pool")
    private Pool pool;

    public MatchListResponse() {
    }

    public List<Match> getMatchList() {
        return matchList;
    }

    public void setMatchList(List<Match> matchList) {
        this.matchList = matchList;
    }

    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }
}
