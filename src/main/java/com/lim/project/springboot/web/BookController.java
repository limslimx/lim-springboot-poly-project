package com.lim.project.springboot.web;

import com.lim.project.springboot.domain.Book;
import com.lim.project.springboot.service.CrawlingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BookController {

    private final CrawlingService crawlingService;

    @GetMapping("/book")
    public List<Book> book() throws Exception {
        return crawlingService.searchBookAndSave("생각에관한생각");
    }
}
