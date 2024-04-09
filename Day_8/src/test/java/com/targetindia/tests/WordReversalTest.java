package com.targetindia.tests;

import com.targetindia.programs.WordReversal;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class WordReversalTest {
    @Test
    public void TestSingleWordReversal(){
        String str = "Hello";
        String expected = str;
        String actual = WordReversal.reverseWords(str);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestMultipleWordsReversal(){
        String str = "Hello World";
        String expected = "World Hello";
        String actual = WordReversal.reverseWords(str);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestLeadingAndTrailingSpaces(){
        String str = " Hello World ";
        String expected = "World Hello";
        String actual = WordReversal.reverseWords(str);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestExtraSpacesBetweenSpaces(){
        String str = "Hello    World";
        String expected = "World Hello";
        String actual = WordReversal.reverseWords(str);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestEmptyString(){
        String str = "";
        String expected = "";
        String actual = WordReversal.reverseWords(str);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestSpecialCharactersAndPunctuationMarks(){
        String str = "Hello, World!!!";
        String expected = "World!!! Hello,";
        String actual = WordReversal.reverseWords(str);
        Assertions.assertEquals(expected, actual);
    }
}
