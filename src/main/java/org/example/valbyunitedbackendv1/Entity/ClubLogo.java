package org.example.valbyunitedbackendv1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ClubLogo {
    @Id
    int id;
    String clubName;
    String logoUrl;


    public ClubLogo(int id, String clubName, String logoUrl) {
        this.id = id;
        this.clubName = clubName;
        this.logoUrl = logoUrl;
    }

    public ClubLogo() {

    }

    public int getId() {
        return id;
    }
    public String getClubName() {
        return clubName;
    }
    public String getLogoUrl() {
        return logoUrl;
    }
    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
    @Override
    public String toString() {
        return "ClubLogo{" +
                "id=" + id +
                ", clubName='" + clubName + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                '}';
    }
}
