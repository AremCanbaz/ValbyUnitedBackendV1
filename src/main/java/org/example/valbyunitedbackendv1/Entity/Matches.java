package org.example.valbyunitedbackendv1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class Matches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String awayTeamName;
    private int awayTeamScore;
    private String homeTeamName;
    private int homeTeamScore;
    private String matchDateTime;
    private int roundNo;
    private String stadiumName;
}
