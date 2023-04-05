package ru.croc.course.article;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.croc.course.support.TextManipulationService;

public class ArticleServiceTest {


    private TextManipulationService textManipulationService;
    private ArticleService articleService;

    @BeforeEach
    public void prepare() {
        this.textManipulationService = Mockito.mock(TextManipulationService.class);
        this.articleService = new ArticleService(textManipulationService);
    }

    @Test
    public void shouldReturnArticleQuality() {
        Mockito.doReturn(new String[] {"hello", "world", "java", "croc", "croc", "corporation"})
                .when(textManipulationService).getReducedToLowercaseWordsInText("Hello-World. (Java CROC) @croc-corporation");
        Mockito.doReturn(new String[] {"java", "course", "in", "this", "article", "we", "try", "to", "create", "hello", "world", "application", "on", "java", "language", "with", "croc", "teachers"})
                .when(textManipulationService).getReducedToLowercaseWordsInText("Java Course. In this article we tru to create Hello World application (on JAVA language with CROC teachers)");
        double actual = articleService.getArticleQuality(new Article("Hello-World. (Java CROC) @croc-corporation", "Java Course. In this article we tru to create Hello World application (on JAVA language with CROC teachers)", null));
        double expected = 5.0/18.0;
        Assertions.assertThat(actual).isEqualTo(expected);

    }

}
