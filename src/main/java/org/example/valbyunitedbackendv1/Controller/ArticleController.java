package org.example.valbyunitedbackendv1.Controller;

import org.example.valbyunitedbackendv1.Entity.Articles;
import org.example.valbyunitedbackendv1.Service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("article")
public class ArticleController {
    @Autowired
    ArticlesService articlesService;

    @GetMapping("/articles")
    public List<Articles> getAllArticles(){
        List<Articles> articles = articlesService.getAllArticles();
        return articles;
    }

}
