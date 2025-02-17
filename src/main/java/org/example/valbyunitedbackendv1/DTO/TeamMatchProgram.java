package org.example.valbyunitedbackendv1.DTO;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.example.valbyunitedbackendv1.Entity.Matches;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "TeamMatchProgram")
public class TeamMatchProgram {
    private MatchList matchList;

    @XmlElement(name = "MatchList")
    public MatchList getMatchList() {
        return matchList;
    }

    public void setMatchList(MatchList matchList) {
        this.matchList = matchList;
    }
}

@XmlRootElement(name = "MatchList")
class MatchList {

    private List<Matches> matches = new ArrayList<>();

    @XmlElementWrapper(name = "Matches")  // Correct the wrapper to Matches
    @XmlElement(name = "Match")  // Each Match in the list is represented as <Match>
    public List<Matches> getMatches() {
        return matches;
    }

    public void setMatches(List<Matches> matches) {
        this.matches = matches;
    }
}
