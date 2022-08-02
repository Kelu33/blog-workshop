package fr.wcs.blog.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CreateArticleDto {

    @NotEmpty(message = "Title required")
    @Size(min = 10, max = 150)
    private String title;

    @NotEmpty(message = "Content required")
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
