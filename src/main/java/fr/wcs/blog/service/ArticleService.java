package fr.wcs.blog.service;

import fr.wcs.blog.dto.CreateArticleDto;
import fr.wcs.blog.entity.Article;
import fr.wcs.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Article create(CreateArticleDto createArticleDto) {
        Article article = new Article();
        article.setTitle(createArticleDto.getTitle());
        article.setContent(createArticleDto.getContent());
        return articleRepository.save(article);
    }

    public Article getById(int id) {
        return articleRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    public Article update(int id, CreateArticleDto createArticleDto) {
        Article articleToUpdate = articleRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );

        articleToUpdate.setTitle(createArticleDto.getTitle());
        articleToUpdate.setContent(createArticleDto.getContent());
        // articleToUpdate.setComments(createArticleDto.getComments());

        return articleRepository.save(articleToUpdate);
    }

    public void delete(int id) {
        try {
            articleRepository.deleteById(id);
        } catch (Exception exception) {
            throw new ResponseStatusException((HttpStatus.NOT_FOUND));
        }
    }
}
