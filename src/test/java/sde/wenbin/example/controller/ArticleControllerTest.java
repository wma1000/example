package sde.wenbin.example.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sde.wenbin.example.model.Article;
import sde.wenbin.example.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {TestContext.class})
@WebMvcTest(value = ArticleController.class)
@EnableSpringDataWebSupport
public class ArticleControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private ArticleService articleService;

    @Before
    public void setup() {
        ArticleController controller = new ArticleController();
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .build();
    }

    @Test
    public void positive_getPageArticles() throws Exception {

        List<Article> content = new ArrayList<>();
        Article article = new Article();
        content.add(article);
        Page<Article> expected = new PageImpl(content);

        Mockito.when(articleService.getPageArticles(PageRequest.of(0, 2))).thenReturn(expected);
        mockMvc.perform(get("/articles"))
                .andExpect(status().isOk()).andExpect(view().name("articles.html"));
    }
}