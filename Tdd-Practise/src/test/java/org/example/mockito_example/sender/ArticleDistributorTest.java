package org.example.mockito_example.sender;

import org.example.mockito_example.article.Article;
import org.example.mockito_example.article.Type;
import org.example.mockito_example.client.Channel;
import org.example.mockito_example.client.EntertainmentChannel;
import org.example.mockito_example.client.OtherChannel;
import org.example.mockito_example.client.SportsChannel;
import org.example.mockito_example.database.ArticleDataAccess;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.example.mockito_example.article.Type.SPORT;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ArticleDistributorTest {

    @Mock
    private SportsChannel sport;
    @Mock
    private EntertainmentChannel entertainment;
    @Mock
    private OtherChannel other;
    @Mock
    private  ArticleDataAccess dataAccess;
    @InjectMocks
    private ArticleDistributor distributor;


    @Test
    public void SportDistributedToRespectiveType(){

        List<Article> list = asList(new Article("Sport is fun",SPORT),new Article("Politices is sad", Type.POLITICS));

        when(dataAccess.getTodaysArticles()).thenReturn(list);


        distributor.distributeToday();

        verify(sport).accept(any());
        verify(other).accept(any());
        verify(entertainment,never()).accept(any());

    }

}