package com.lim.project.springboot.domain;

import com.lim.project.springboot.web.dto.BookDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select new com.lim.project.springboot.web.dto.BookDto(b.searchDate, b.name, b.subName, b.img, b.author, b.category, b.detailCategory, b.rank, b.tag, b.url, b.publicationDate) from Book b where b.name=:name and b.searchDate=:searchDate")
    List<BookDto> findBookByName(@Param("name") String name, @Param("searchDate") String searchDate);
}

