package ru.croc.course.article;

import ru.croc.course.author.Author;

public class Article {

    private Integer id;
    private String title;
    private String text;
    private Author author;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Article(String title, String text, Author author) {
        this.title = title;
        this.text = text;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
