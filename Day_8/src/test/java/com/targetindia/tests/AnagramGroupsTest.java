package com.targetindia.tests;

import com.targetindia.programs.AnagramGroups;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class AnagramGroupsTest {

    @Test
    public void testContainingAnagram(){
        String input[] = {"cat", "but", "tac", "tub"};
        List<List<String>> exp = new ArrayList<>();
        List<String> ls = new ArrayList<>();
        ls.add("but");
        ls.add("tub");
        exp.add(ls);
        ls = new ArrayList<>();
        ls.add("cat");
        ls.add("tac");
        exp.add(ls);

        List<List<String>> actual = AnagramGroups.groupAnagrams(input);
        Assertions.assertEquals(exp, actual);
    }

    @Test
    public void testNotContainingAnagram(){
        String input[] = {"cat", "bat", "tic", "rat"};
        List<List<String>> exp = new ArrayList<>();
        List<String> ls = new ArrayList<>();
        ls.add("bat");
        exp.add(ls);
        ls = new ArrayList<>();
        ls.add("rat");
        exp.add(ls);
        ls = new ArrayList<>();
        ls.add("cat");
        exp.add(ls);
        ls = new ArrayList<>();
        ls.add("tic");
        exp.add(ls);

        List<List<String>> actual = AnagramGroups.groupAnagrams(input);
        Assertions.assertEquals(exp, actual);

    }

    @Test
    //TEST FAILS INSPITE OF IDENTICAL CONTENT OF THE OUTPUT
    public void testEmptyArray(){
        String input[] = {""};
        List<List<String>> exp = new ArrayList<>();
        List<String> ls = new ArrayList<>();
        exp.add(ls);

        List<List<String>> actual = AnagramGroups.groupAnagrams(input);
        Assertions.assertEquals(exp, actual);

    }

    @Test
    public void testWordsDifferentLength(){
        String input[] = {"cat", "butter", "hello"};
        List<List<String>> exp = new ArrayList<>();
        List<String> ls = new ArrayList<>();
        ls.add("cat");
        exp.add(ls);
        ls = new ArrayList<>();
        ls.add("butter");
        exp.add(ls);
        ls = new ArrayList<>();
        ls.add("hello");
        exp.add(ls);

        List<List<String>> actual = AnagramGroups.groupAnagrams(input);
        Assertions.assertEquals(exp, actual);

    }

    @Test
    public void testWithSpecialChar(){
        String input[] = {",%^", "bu!t", "^,%", "tub!"};
        List<List<String>> exp = new ArrayList<>();
        List<String> ls = new ArrayList<>();
        ls.add("bu!t");
        ls.add("tub!");
        exp.add(ls);
        ls = new ArrayList<>();
        ls.add(",%^");
        ls.add("^,%");
        exp.add(ls);

        List<List<String>> actual = AnagramGroups.groupAnagrams(input);
        Assertions.assertEquals(exp, actual);

    }

    @Test
    public void testMixOfLowerAndUpperCaseLetters(){
        String input[] = {"Cat", "bUt", "taC", "ATc", "tUb"};
        List<List<String>> exp = new ArrayList<>();
        List<String> ls = new ArrayList<>();
        ls.add("ATc");
        exp.add(ls);
        ls = new ArrayList<>();
        ls.add("bUt");
        ls.add("tUb");
        exp.add(ls);
        ls = new ArrayList<>();
        ls.add("Cat");
        ls.add("taC");
        exp.add(ls);

        List<List<String>> actual = AnagramGroups.groupAnagrams(input);
        Assertions.assertEquals(exp, actual);

    }

}
