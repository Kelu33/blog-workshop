package fr.wcs.blog.service;

import fr.wcs.blog.dto.CommentDto;
import fr.wcs.blog.entity.Article;
import fr.wcs.blog.entity.Comment;
import fr.wcs.blog.repository.ArticleRepository;
import fr.wcs.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    ArticleService articleService;

    public List<Comment> findAll(int id) {
        Article article = articleService.getById(id);
        return commentRepository.findByArticle(article);
    }

    public Comment create(int id, CommentDto commentDto) {
        Article article = articleService.getById(id);
        Comment comment = new Comment(commentDto.getContent(), article);

        return commentRepository.save(comment);
    }

    public Comment update(int idComment, CommentDto commentDto) {
        Comment comment = commentRepository.findById(idComment).orElseThrow(
                () -> new ResponseStatusException((HttpStatus.NOT_FOUND))
        );
        comment.setContent(commentDto.getContent());

        return commentRepository.save(comment);
    }

    public void delete(int idComment) {
        try {
            commentRepository.deleteById(idComment);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

}
