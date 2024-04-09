package com.targetindia.tests;

import com.targetindia.programs.PrimeFactorization;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorizationTest {
    @Test
    public void testPrimeNumber(){
        int n = 7;
        List<Integer> expected = new ArrayList<>();
        expected.add(n);
        List<Integer> actual = PrimeFactorization.primeFactors(n);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCompositeNumber(){
        int n = 12;
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(3);
        List<Integer> actual =PrimeFactorization.primeFactors(n);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testNumberWithOnePrimeFactor(){
        int n = 5;
        List<Integer> expected = new ArrayList<>();
        expected.add(5);
        List<Integer> actual =PrimeFactorization.primeFactors(n);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testNegativeNumber(){
        int n = -12;
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual =PrimeFactorization.primeFactors(n);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWithZero(){
        int n = 0;
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual =PrimeFactorization.primeFactors(n);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWithOne(){
        int n = 1;
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual =PrimeFactorization.primeFactors(n);
        Assertions.assertEquals(expected, actual);
    }
}
