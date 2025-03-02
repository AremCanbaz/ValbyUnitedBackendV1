package org.example.valbyunitedbackendv1.Repository;

import org.example.valbyunitedbackendv1.Entity.ClubLogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import static org.apache.coyote.http11.Constants.a;


public interface ClubLogoRepository extends JpaRepository<ClubLogo, Long> {
    @Query("SELECT c.logoUrl FROM ClubLogo c WHERE c.clubName = :clubName")
    String findLogoUrlByClubName(@Param("clubName") String clubName);

}
