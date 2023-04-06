package ru.croc.course.support;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
/** Класс тестирующий функциональность сервиса по работе с текстом  */
public class TextManipulationServiceTest {
    private final TextManipulationService textManipulationService = new TextManipulationService();


    /** Данный тест позволяет убедиться, что функциональность по
     * удалению всех заданных слов из текста работает корректно. */
    @Test
    public void shouldRemoveAllWordsInText() {
        String[] words = new String[]{"first", "second", "third"};
        String text = "first last second second previous";
        String actual = textManipulationService.removeAllWordsInText(words, text);
        String expected = " last   previous";
        Assertions.assertThat(actual).isEqualTo(expected);
    }
    /** Данный тест позволяет убедиться, что функциональность по получению всех
     * слов, приведенных к нижнему регистру, из текста работает корректно. */
    @Test
    public void shouldReturnReducedToLowercaseWordsInText() {
        String text = "qwerty, . Qwerty! Hi hiHHH ";
        String[] actual = textManipulationService.getReducedToLowercaseWordsInText(text);
        String[] expected = new String[]{"qwerty", "qwerty", "hi", "hihhh"};
        Assertions.assertThat(actual).contains(expected);
        Assertions.assertThat(actual).hasSize(4);
    }
}
