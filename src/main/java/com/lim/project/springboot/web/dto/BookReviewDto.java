package com.lim.project.springboot.web.dto;

import com.lim.project.springboot.domain.BookReview;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookReviewDto {

    private Long id;

    private String name;

    private String author;

    private String category;

    private String title;

    private String content;


    public BookReviewDto(BookReview entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.author = entity.getAuthor();
        this.category = entity.getCategory();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }

    public BookReviewDto(Long id, String name, String author, String category, String title, String content) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
        this.title = title;
        this.content = content;
    }

    public BookReview toEntity() {
        return BookReview.builder()
                .name(name)
                .author(author)
                .category(category)
                .title(title)
                .content(content)
                .build();
    }
}
