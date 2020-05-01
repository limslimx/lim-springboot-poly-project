package com.lim.project.springboot.service.book;

import com.lim.project.springboot.domain.BookRepository;
import com.lim.project.springboot.service.CrawlingService;
import com.lim.project.springboot.util.DateUtil;
import com.lim.project.springboot.web.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Transactional
@Service
public class BookService {

    private Logger log = Logger.getLogger(String.valueOf(this.getClass()));
    private final BookRepository bookRepository;
    private final CrawlingService crawlingService;

    public List<BookDto> getBookSearchInfo(String searchBy) throws Exception {
        log.info(this.getClass().getName() + ".getBookSearchInfo start!");

        List<BookDto> bookDtoList = bookRepository.findBookByDate(searchBy, DateUtil.getDateTime("yyyyMMdd"));

        if (bookDtoList == null) {
            bookDtoList = new ArrayList<BookDto>();
        }
        if (bookDtoList.size() == 0) {
            crawlingService.searchBookAndSave(searchBy);
            bookDtoList = bookRepository.findBookByDate(searchBy, DateUtil.getDateTime("yyyyMMdd"));

            if (bookDtoList == null) {
                bookDtoList = new ArrayList<BookDto>();
            }
        }
        log.info(this.getClass().getName() + ".getBookSearchInfo end!");
        return bookDtoList;
    }
}
