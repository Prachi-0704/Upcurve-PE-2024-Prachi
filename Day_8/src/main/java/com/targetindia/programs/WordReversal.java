package com.targetindia.programs;
import java.util.*;

public class WordReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER A SENTENCE:");
        String input = sc.nextLine();

        System.out.println(reverseWords(input));
    }

    public static String reverseWords(String str){
        String[] strSplit = str.trim().split("\\s+");       //input string is split at white spaces
        int n = strSplit.length;
        for(int i=0; i<(n/2); i++){
            String temp = strSplit[i];
            strSplit[i] = strSplit[n-1-i];
            strSplit[n-1-i] = temp;
        }
        String strReverse = "";
        for(int i=0; i<n-1; i++){
            strReverse += strSplit[i]+" ";
        }
        strReverse += strSplit[n-1];
        return strReverse;
    }
}
