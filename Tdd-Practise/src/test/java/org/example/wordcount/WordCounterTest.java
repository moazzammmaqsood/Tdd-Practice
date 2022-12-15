package org.example.wordcount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {

    private WordCounter counter=new WordCounter();

    @Test
    public void emptyStringHasNoWords(){
        counter.add("");
        assertEquals(0,counter.getUniqueWordsCount());
    }

    @Test
    public void singleWordStringhasOneWord()
    {
        counter.add("Hello");
        assertEquals(1,counter.getUniqueWordsCount());
    }


    @Test
    public void singleWordStringhasTwoWord()
    {
        counter.add("Hello");
        counter.add("World");
        assertEquals(2,counter.getUniqueWordsCount());
    }

    @Test
    public void multiWordStringHasCorrectWord(){
        counter.add("One two three");
        assertEquals(3,counter.getUniqueWordsCount());
    }
    @Test
    public void multiWordStringSpacedOutHasCorrectWord(){
        counter.add("     One   two three   ");
        assertEquals(3,counter.getUniqueWordsCount());
    }


    @Test
    public void inputWithDuplicatesCountsOnlyIndividualCases(){
        counter.add("Nine Nine Nine");
        assertEquals(1,counter.getUniqueWordsCount());
    }

    @Test
    public void inputWithDuplicatesMixedCasesCountsOnlyIndividualCases(){
        counter.add("Nine nine NiNe");
        assertEquals(1,counter.getUniqueWordsCount());
    }


    @Test
    public  void inputWithPunctuationStillSpotDuplicates(){
        counter.add("Nine.");
        counter.add("Nine ten.");
        counter.add("Nine, ten, eleven.");
        assertEquals(3,counter.getUniqueWordsCount());

    }
}