package ru.croc.course.article;

import ru.croc.course.support.TextManipulationService;

import java.util.*;

public class ArticleService {

    private final TextManipulationService textManipulationService;

    public ArticleService(TextManipulationService textManipulationService) {
        this.textManipulationService = textManipulationService;
    }

    public double getArticleQuality(Article article) {
        String[] wordsInTitle = textManipulationService.getReducedToLowercaseWordsInText(article.getTitle());
        Set<String> uniqueWordsInTitle = new HashSet<String>(Arrays.asList(wordsInTitle));
        String[] wordsInText = textManipulationService.getReducedToLowercaseWordsInText(article.getText());
        double quality = 0.0;
        int countWordsInText = wordsInText.length;
        int countWordsOccurrence = 0;
        for (String uniqueWord : uniqueWordsInTitle) {
            countWordsOccurrence += Collections.frequency(List.of(wordsInText), uniqueWord);
        }
        return (double)countWordsOccurrence/countWordsInText;
    }

}
