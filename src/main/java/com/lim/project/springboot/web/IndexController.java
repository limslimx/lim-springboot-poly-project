package com.lim.project.springboot.web;

import com.lim.project.springboot.domain.BookReview;
import com.lim.project.springboot.domain.BookReviewRepository;
import com.lim.project.springboot.service.bookReview.BookReviewService;
import com.lim.project.springboot.web.dto.BookReviewDto;
import com.lim.project.springboot.web.dto.ToBookReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private Logger log = Logger.getLogger(String.valueOf(this.getClass()));
    private final BookReviewService bookReviewService;
    private final BookReviewRepository bookReviewRepository;

    @GetMapping("/book/index")
    public String index() {
        return "book/index";
    }

    @GetMapping("/book/review")
    public String bookReview(HttpSession session, Model model) {
        model.addAttribute("name", session.getAttribute("name"));
        model.addAttribute("author", session.getAttribute("author"));
        model.addAttribute("category", session.getAttribute("category"));
        return "/book/review";
    }

    @GetMapping("/book/review/list")
    public String bookReviewList(Model model) {
        log.info(this.getClass().getName() + ".bookReviewList start!");

        List<BookReviewDto> allDesc = bookReviewService.findAllDesc();

        model.addAttribute("reviewList", allDesc);

        log.info(this.getClass().getName() + ".bookReviewList end!");

        return "/book/reviewList";
    }

    @GetMapping("/book/review/detail/{id}")
    public String bookReviewDetail(@PathVariable Long id, Model model) {
        log.info(this.getClass().getName() + ".bookReviewDetail start!");

        BookReviewDto one = bookReviewService.findOne(id);
        model.addAttribute("reviewDetail", one);

        log.info(this.getClass().getName() + ".bookReviewDetail end!");

        return "/book/reviewDetail";
    }
}
