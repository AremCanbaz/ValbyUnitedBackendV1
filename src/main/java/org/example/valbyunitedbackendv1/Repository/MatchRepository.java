package org.example.valbyunitedbackendv1.Repository;

import org.example.valbyunitedbackendv1.Entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}

