package org.example.mockito_example.sender;

import org.example.mockito_example.article.Article;
import org.example.mockito_example.client.Channel;
import org.example.mockito_example.client.EntertainmentChannel;
import org.example.mockito_example.client.OtherChannel;
import org.example.mockito_example.client.SportsChannel;
import org.example.mockito_example.database.ArticleDataAccess;

public class ArticleDistributor {

    private SportsChannel sport ;
    private EntertainmentChannel entertainment;
    private OtherChannel other;
    private ArticleDataAccess dataAccess;

    public ArticleDistributor(SportsChannel sport, EntertainmentChannel entertainment, OtherChannel other, ArticleDataAccess dataAccess) {
        this.sport = sport;
        this.entertainment = entertainment;
        this.other = other;
        this.dataAccess = dataAccess;
    }

    public void distributeToday() {
        for(Article article:dataAccess.getTodaysArticles()){
            switch (article.getType()){
                case SPORT:
                    sport.accept(article);
                    break;
                case ENTERTAINMENT:
                    entertainment.accept(article);
                    break;
                default:
                    other.accept(article);
                    break;
            }
        }
    }
}
