package ru.croc.course.author;

import ru.croc.course.article.Article;

import java.util.List;

public class Author {
    private Integer id;
    private String name;
    private List<Article> articles;

    public Author(String name, List<Article> articles) {
        this.name = name;
        this.articles = articles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
