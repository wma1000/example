package sde.wenbin.example.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sde.wenbin.example.model.Article;
import sde.wenbin.example.repository.ArticleRepository;

@Service
@RequiredArgsConstructor
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getAllArticles() {

        return articleRepository.findAll();
    }

    public Page<Article> getPageArticles(Pageable pageable) {

        return articleRepository.findAll(pageable);
    }
}
