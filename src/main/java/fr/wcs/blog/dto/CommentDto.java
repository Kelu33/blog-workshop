package fr.wcs.blog.dto;

import javax.validation.constraints.NotEmpty;

public class CommentDto {

    @NotEmpty(message = "Content is required")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
