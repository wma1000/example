package sde.wenbin.example.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import sde.wenbin.example.model.Article;
import sde.wenbin.example.service.ArticleService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ArticleController.class)
public class ArticleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleService articleService;

    @Test
    @Ignore
    public void getPageArticlesTest() throws Exception {

        List<Article> content = new ArrayList<>();
        Article article = new Article();
        content.add(article);
        content.add(new Article());
        Page<Article> expected = new PageImpl(content, PageRequest.of(0, 2, Sort.Direction.DESC, "score"), content.size());

        Mockito.when(articleService.getPageArticles(PageRequest.of(0, 2))).thenReturn(expected);

        mockMvc.perform(get("/articles")
                .param("page", "0")
                .param("size", "2")
                .param("sort", "score,desc"))
                .andExpect(status().isOk())
                .andExpect(view().name("articles.html"));
    }
}