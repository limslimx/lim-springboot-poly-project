package com.lim.project.springboot.web;

import com.lim.project.springboot.service.CrawlingService;
import com.lim.project.springboot.service.book.BookService;
import com.lim.project.springboot.web.dto.BookDto;
import com.lim.project.springboot.web.dto.BookSearchRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RequiredArgsConstructor
@RestController
public class BookController {

    private Logger log = Logger.getLogger(String.valueOf(this.getClass()));
    private final CrawlingService crawlingService;
    private final BookService bookService;

    @PostMapping("/book/info")
    public List<BookDto> bookSearch(@RequestBody BookDto requestDto) throws Exception {
        log.info(this.getClass().getName()+".bookSearch start!");

        List<BookDto> bookDtoList = null;
        String searchBy = requestDto.getSearchBy();
        log.info(searchBy);
        bookDtoList = bookService.getBookSearchInfo(searchBy);

        if (bookDtoList == null) {
            bookDtoList = new ArrayList<BookDto>();
        }
        log.info(this.getClass().getName()+".bookSearch end!");
        return bookDtoList;
    }
}
