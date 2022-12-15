package org.example.mockito_example.database;

import org.example.mockito_example.article.Article;

import java.util.List;

public interface ArticleDataAccess {
    List<Article> getTodaysArticles();
}
