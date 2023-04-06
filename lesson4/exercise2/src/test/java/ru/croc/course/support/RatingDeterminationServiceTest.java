package ru.croc.course.support;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.croc.course.article.Article;
import ru.croc.course.article.ArticleService;
import ru.croc.course.author.Author;
import ru.croc.course.author.AuthorService;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/** Класс тестирующий функциональность сервиса по работе с выставлением рейтинга  */
public class RatingDeterminationServiceTest {

    private ArticleService articleService;
    private AuthorService authorService;
    private RatingDeterminationService ratingDeterminationService;

    private static final Article ARTICLE_1 = new Article("some_title", "some_text");
    private static final Article ARTICLE_2 = new Article("some_title", "some_text");
    private static final Article ARTICLE_3 = new Article("some_title", "some_text");
    private static final Article ARTICLE_4 = new Article("some_title", "some_text");
    private static final Article ARTICLE_5 = new Article("some_title", "some_text");
    private static final Author AUTHOR_1 = new Author("author1", List.of(ARTICLE_1, ARTICLE_5));
    private static final Author AUTHOR_2 = new Author("author2", List.of(ARTICLE_4, ARTICLE_3, ARTICLE_2));
    private static final Author AUTHOR_3 = new Author("author3", Collections.emptyList());



    /** Метод подготавливает объект для модульного тестирования */
    @BeforeEach
    public void prepare() {
        this.articleService = Mockito.mock(ArticleService.class);
        this.authorService = Mockito.mock(AuthorService.class);
        this.ratingDeterminationService = new RatingDeterminationService(articleService, authorService);
    }
    /** Данный тест позволяет убедиться, что коллекция Map, где ключом
     * является автор, а значением его рейтинг формируется корректно. */
    @Test
    public void shouldReturnAuthorsAssociatedToRating() {
        Mockito.doReturn(List.of(AUTHOR_1, AUTHOR_2, AUTHOR_3)).when(authorService).getAll();
        Mockito.doReturn(0.5).when(articleService).getArticleQuality(ARTICLE_1);
        Mockito.doReturn(0.33).when(articleService).getArticleQuality(ARTICLE_2);
        Mockito.doReturn(0.12).when(articleService).getArticleQuality(ARTICLE_3);
        Mockito.doReturn(0.32).when(articleService).getArticleQuality(ARTICLE_4);
        Mockito.doReturn(0.87).when(articleService).getArticleQuality(ARTICLE_5);
        Map<Author, Double> actual = ratingDeterminationService.determineAuthorsRating();

        Map<Author, Double> expected = new HashMap<>();
        expected.put(AUTHOR_1, 0.685);
        expected.put(AUTHOR_2, (0.33 + 0.12 + 0.32)/3);
        expected.put(AUTHOR_3, 0.0);
        Assertions.assertThat(actual.keySet()).containsAll(expected.keySet());
        Assertions.assertThat(expected).containsAllEntriesOf(actual);
    }



}