package sde.wenbin.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sde.wenbin.example.model.Article;

@RepositoryRestResource(collectionResourceRel = "article", path = "article")
public interface ArticleRepository extends MongoRepository<Article, String> {

}
