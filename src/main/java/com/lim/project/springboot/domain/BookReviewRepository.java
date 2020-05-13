package com.lim.project.springboot.domain;

import com.lim.project.springboot.web.dto.BookReviewDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookReviewRepository extends JpaRepository<BookReview, Long> {

    @Query("select new com.lim.project.springboot.web.dto.BookReviewDto(br) from BookReview br order by br.id")
    List<BookReviewDto> findAllDesc();

    BookReviewDto findOneById(Long id);
}
