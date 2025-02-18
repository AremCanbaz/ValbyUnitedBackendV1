package org.example.valbyunitedbackendv1.Repository;

import org.example.valbyunitedbackendv1.Entity.Matches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatchRepository extends JpaRepository<Matches, Long> {
}
