package com.lim.project.springboot.web;

import com.lim.project.springboot.web.dto.ToBookReviewDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.logging.Logger;

@Controller
public class IndexController {

    private Logger log = Logger.getLogger(String.valueOf(this.getClass()));

    @GetMapping("/book/index")
    public String index(){
        return "book/index";
    }

    @PostMapping("/book/review")
    public String bookReview(@RequestBody ToBookReviewDto toBookReviewDto, Model model) {
        log.info(this.getClass().getName() + ".bookReview start!");

        model.addAttribute("name", toBookReviewDto.getName());
        model.addAttribute("author", toBookReviewDto.getAuthor());
        model.addAttribute("category", toBookReviewDto.getCategory());

        log.info(this.getClass().getName() + ".bookReview end!");

        return "book/review";
    }


}
