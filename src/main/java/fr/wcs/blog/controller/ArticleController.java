package fr.wcs.blog.controller;

import fr.wcs.blog.dto.CreateArticleDto;
import fr.wcs.blog.entity.Article;
import fr.wcs.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping
    public List<Article> list() {
        return articleService.findAll();
    }

    @GetMapping("/{id}")
    public Article getById(@PathVariable int id) {
        return articleService.getById(id);
    }

    @PostMapping
    public Article create(@RequestBody @Valid CreateArticleDto createArticleDto, HttpServletResponse response) {
        return articleService.create(createArticleDto);
    }

    @PutMapping("/{id}")
    public Article update(@PathVariable int id, @RequestBody @Valid CreateArticleDto createArticleDto) {
        return articleService.update(id, createArticleDto);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        articleService.delete(id);
    }

}
