package fr.wcs.blog.controller;

import fr.wcs.blog.dto.CommentDto;
import fr.wcs.blog.entity.Comment;
import fr.wcs.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/articles/{id}/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Comment> list(@PathVariable int id) {
        return commentService.findAll(id);
    }

    @PostMapping
    public Comment create(@PathVariable int id, @RequestBody @Valid CommentDto commentDto) {
        return commentService.create(id, commentDto);
    }

    @PutMapping("/{idComment}")
    public Comment update(@PathVariable int idComment, @RequestBody @Valid CommentDto commentDto) {
        return commentService.update(idComment, commentDto);
    }

    @DeleteMapping("/{idComment}")
    public void delete(@PathVariable int idComment) {
        commentService.delete(idComment);
    }

}
