package sde.wenbin.example.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import sde.wenbin.example.model.Article;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void test_getPageableArticles() {
        Pageable pageable = PageRequest.of(0, 2);
        Page<Article> page = articleRepository.findAll(pageable);
        assertTrue(page.isFirst());
        assertEquals(page.getContent().size(), 2);
    }
}
