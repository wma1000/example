package sde.wenbin.example.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Article {
    @Id
    private String id;

    private String name;

    private List<String> authors;

    private String url;

    private List<String> keywords;

    private Integer score;

    public Article() {

    }

    public String getId() {

        return this.id;
    }

    public String getName() {

        return this.name;
    }

    public List<String> getAuthors() {

        return this.authors;
    }

    public String getUrl() {

        return this.url;
    }

    public List<String> getKeywords() {

        return this.keywords;
    }

    public Integer getScore() {

        return this.score;
    }

    public void setId(String id) {

        this.id = id;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setAuthors(List<String> authors) {

        this.authors = authors;
    }

    public void setUrl(String url) {

        this.url = url;
    }

    public void setKeywords(List<String> keywords) {

        this.keywords = keywords;
    }

    public void setScore(Integer score) {

        this.score = score;
    }

    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        }
        if (!(o instanceof Article)) {
            return false;
        }
        final Article other = (Article) o;
        if (!other.canEqual((Object) this)) {
            return false;
        }
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
            return false;
        }
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        final Object this$authors = this.getAuthors();
        final Object other$authors = other.getAuthors();
        if (this$authors == null ? other$authors != null : !this$authors.equals(other$authors)) {
            return false;
        }
        final Object this$url = this.getUrl();
        final Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) {
            return false;
        }
        final Object this$keyWords = this.getKeywords();
        final Object other$keyWords = other.getKeywords();
        if (this$keyWords == null ? other$keyWords != null : !this$keyWords.equals(other$keyWords)) {
            return false;
        }
        final Object this$score = this.getScore();
        final Object other$score = other.getScore();
        if (this$score == null ? other$score != null : !this$score.equals(other$score)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(final Object other) {

        return other instanceof Article;
    }

    public int hashCode() {

        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $authors = this.getAuthors();
        result = result * PRIME + ($authors == null ? 43 : $authors.hashCode());
        final Object $url = this.getUrl();
        result = result * PRIME + ($url == null ? 43 : $url.hashCode());
        final Object $keyWords = this.getKeywords();
        result = result * PRIME + ($keyWords == null ? 43 : $keyWords.hashCode());
        final Object $score = this.getScore();
        result = result * PRIME + ($score == null ? 43 : $score.hashCode());
        return result;
    }

    public String toString() {

        return "Article(id=" + this.getId() + ", name=" + this.getName() + ", authors=" + this.getAuthors() + ", url=" + this.getUrl() + ", keywords=" + this.getKeywords() + ", score=" + this
                .getScore() + ")";
    }
}
