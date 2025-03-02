package org.example.valbyunitedbackendv1.Service;

import org.example.valbyunitedbackendv1.Entity.Articles;
import org.example.valbyunitedbackendv1.Repository.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlesService {
    @Autowired
    private ArticlesRepository articlesRepository;

    public List<Articles> getAllArticles() {
        return articlesRepository.findAll();
    }
}
