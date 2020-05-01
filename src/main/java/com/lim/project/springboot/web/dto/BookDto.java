package com.lim.project.springboot.web.dto;

import com.lim.project.springboot.domain.Book;
import lombok.Builder;
import lombok.Data;

@Data
public class BookDto {

    private String searchDate;

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
    public BookDto(String searchDate, String name, String subName, String img, String author, String category, String detailCategory, String rank, String tag, String url, String publicationDate) {
        this.searchDate = searchDate;
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

    public Book toEntity(){
        return Book.builder()
                .searchDate(searchDate)
                .name(name)
                .subName(subName)
                .img(img)
                .author(author)
                .category(category)
                .detailCategory(detailCategory)
                .rank(rank)
                .tag(tag)
                .url(url)
                .publicationDate(publicationDate)
                .build();
    }
}
