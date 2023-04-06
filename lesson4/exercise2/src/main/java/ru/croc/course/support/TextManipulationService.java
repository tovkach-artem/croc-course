package ru.croc.course.support;
/** Высокоуровневый сервис по работе с текстом */
public class TextManipulationService {
    /** Метод позволяет получить массив слов, приведенных к нижнему регистру из текста */
    public String[] getReducedToLowercaseWordsInText(String text) {
        return text.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
    }
    /** Метод позволяет удалить все заданные слова из текста */
    public String removeAllWordsInText(String[] words, String text) {
        String result = text;
        for (String word : words) {
            result = result.replaceAll(word, "");
        }
        return result;
    }
}
