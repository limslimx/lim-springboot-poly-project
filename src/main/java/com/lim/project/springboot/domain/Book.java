package com.lim.project.springboot.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    private String searchDate;

    private String searchBy;

    private String name;

    private String subName;

    private String img;

    private String author;

    private String category;

    private String detailCategory;

    private String rank;

    private String tag;

    private String url;

    private String publicationDate;

    @Builder
    public Book(String searchDate, String searchBy, String name, String subName, String img, String author, String category, String detailCategory, String rank, String tag, String url, String publicationDate) {
        this.searchDate = searchDate;
        this.searchBy = searchBy;
        this.name = name;
        this.subName = subName;
        this.img = img;
        this.author = author;
        this.category = category;
        this.detailCategory = detailCategory;
        this.rank = rank;
        this.tag = tag;
        this.url = url;
        this.publicationDate = publicationDate;
    }
}
