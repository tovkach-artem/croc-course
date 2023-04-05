package ru.croc.course.support;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TextManipulationServiceTest {
    private final TextManipulationService textManipulationService = new TextManipulationService();

    @Test
    public void shouldRemoveAllWordsInText() {
        String[] words = new String[]{"first", "second", "third"};
        String text = "first last second second previous";
        String actual = textManipulationService.removeAllWordsInText(words, text);
        String expected = " last   previous";
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldReturnReducedToLowercaseWordsInText() {
        String text = "qwerty, . Qwerty! Hi hiHHH ";
        String[] actual = textManipulationService.getReducedToLowercaseWordsInText(text);
        String[] expected = new String[]{"qwerty", "qwerty", "hi", "hihhh"};
        Assertions.assertThat(actual).contains(expected);
        Assertions.assertThat(actual).hasSize(4);
    }
}
