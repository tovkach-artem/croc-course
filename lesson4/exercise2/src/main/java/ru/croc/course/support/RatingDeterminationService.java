package ru.croc.course.support;

import ru.croc.course.article.Article;
import ru.croc.course.article.ArticleService;
import ru.croc.course.author.Author;
import ru.croc.course.author.AuthorService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatingDeterminationService {

    private final ArticleService articleService;

    private final AuthorService authorService;

    public RatingDeterminationService(ArticleService articleService, AuthorService authorService) {
        this.articleService = articleService;
        this.authorService = authorService;
    }

    public Map<Author, Double> determineAuthorsRating() {
        Map<Author, Double> authorToRating = new HashMap<>();
        List<Author> authors = authorService.getAll();
        for (Author author : authors) {
            authorToRating.put(author, determineAuthorRating(author));
        }
        return authorToRating;
    }

    public double determineAuthorRating(Author author) {
        List<Article> articles = author.getArticles();
        double totalNumberOfPoints = 0.0;
        if(articles.isEmpty()) {
            return totalNumberOfPoints;
        }
        for (Article article : articles) {
            totalNumberOfPoints += articleService.getArticleQuality(article);
        }
        return totalNumberOfPoints / articles.size();
    }
}
