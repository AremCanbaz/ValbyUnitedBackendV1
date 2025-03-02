package org.example.valbyunitedbackendv1.Repository;

import org.example.valbyunitedbackendv1.Entity.Articles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesRepository extends JpaRepository<Articles, Integer> {
}
