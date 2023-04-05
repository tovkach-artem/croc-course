package ru.croc.course.support;

public class TextManipulationService {

    public String[] getReducedToLowercaseWordsInText(String text) {
        return text.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
    }

    public String removeAllWordsInText(String[] words, String text) {
        String result = text;
        for (String word : words) {
            result = result.replaceAll(word, "");
        }
        return result;
    }
}
