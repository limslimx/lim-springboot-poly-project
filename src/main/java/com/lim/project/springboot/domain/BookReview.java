package com.lim.project.springboot.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class BookReview {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookReview_id")
    private Long id;

    private String name;

    private String author;

    private String category;

    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;


    @Builder
    public BookReview(String name, String author, String category, String title, String content) {
        this.name = name;
        this.author = author;
        this.category = category;
        this.title = title;
        this.content = content;
    }
}
