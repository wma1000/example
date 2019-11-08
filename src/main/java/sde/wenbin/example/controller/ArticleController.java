package sde.wenbin.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sde.wenbin.example.model.Article;
import sde.wenbin.example.service.ArticleService;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/articles", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getPageArticles(Model model, @PageableDefault(size = 3) @SortDefault(value = "rank", direction = Direction.DESC) Pageable pageable) {

        Page<Article> pages = articleService.getPageArticles(pageable);

        model.addAttribute("pages", pages);
        return "articles";
    }
}
