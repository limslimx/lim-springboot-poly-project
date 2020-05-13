package com.lim.project.springboot.service.bookReview;

import com.lim.project.springboot.domain.BookReviewRepository;
import com.lim.project.springboot.web.dto.BookReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Transactional
@Service
public class BookReviewService {

    private Logger log = Logger.getLogger(String.valueOf(this.getClass()));
    private final BookReviewRepository bookReviewRepository;

    public Long saveBookReview(BookReviewDto bookReviewDto) {
        log.info(this.getClass().getName()+".saveBookReview start!");
        log.info(bookReviewDto.getName());
        log.info(bookReviewDto.getAuthor());
        log.info(bookReviewDto.getCategory());
        log.info(bookReviewDto.getTitle());
        log.info(bookReviewDto.getContent());

        return bookReviewRepository.save(bookReviewDto.toEntity()).getId();
    }

    public List<BookReviewDto> findAllDesc() {
        log.info(this.getClass().getName() + ".findAll start!");

        return bookReviewRepository.findAllDesc();
    }

    public BookReviewDto findOne(Long id) {
        log.info(this.getClass().getName() + ".findOne start");

        return bookReviewRepository.findOneById(id);
    }
}
