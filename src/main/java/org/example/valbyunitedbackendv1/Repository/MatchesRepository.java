package org.example.valbyunitedbackendv1.Repository;

import org.example.valbyunitedbackendv1.Entity.Matches;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchesRepository extends JpaRepository<Matches, Long> {
}
