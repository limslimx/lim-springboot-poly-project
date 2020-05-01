package com.lim.project.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookSearchRequestDto {

    private String bookName;

    @Builder
    public BookSearchRequestDto(String bookName){
        this.bookName = bookName;
    }

}
