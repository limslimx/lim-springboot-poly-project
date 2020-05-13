package com.lim.project.springboot.web;

import com.lim.project.springboot.service.bookReview.BookReviewService;
import com.lim.project.springboot.web.dto.BookReviewDto;
import com.lim.project.springboot.web.dto.ToBookReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

@RequiredArgsConstructor
@RestController
public class BookReviewController {

    private Logger log = Logger.getLogger(String.valueOf(this.getClass()));
    private final BookReviewService bookReviewService;

    @PostMapping("/book/review")
    public void bookReview(@RequestBody ToBookReviewDto toBookReviewDto, HttpSession session) {
        log.info(this.getClass().getName() + ".bookReview start!");

        session.setAttribute("name", toBookReviewDto.getName());
        session.setAttribute("author", toBookReviewDto.getAuthor());
        session.setAttribute("category", toBookReviewDto.getCategory());

        log.info(this.getClass().getName() + ".bookReview end!");
    }

    @PostMapping("/book/review/save")
    public Long bookReviewSave(@RequestBody BookReviewDto bookReviewDto) {
        log.info(this.getClass().getName() + ".bookReviewSave start!");
        log.info(this.getClass().getName() + ".bookReviewSave end!");
        log.info(bookReviewDto.getName());
        log.info(bookReviewDto.getAuthor());
        log.info(bookReviewDto.getCategory());
        log.info(bookReviewDto.getTitle());
        log.info(bookReviewDto.getContent());

        return bookReviewService.saveBookReview(bookReviewDto);
    }
}
