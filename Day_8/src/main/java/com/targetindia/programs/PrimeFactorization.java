package com.targetindia.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeFactorization {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER A NUMBER: ");
        int num = sc.nextInt();
        System.out.println(primeFactors(num));
    }

    public static List<Integer> primeFactors(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=2; i<=n; i++){
            if(isPrime(i)==true && (n%i == 0)){
                ans.add(i);
            }
        }
        return ans;
    }

    public static boolean isPrime(int n){
        int i=0;
        for(i=2; i<=n; i++){
            if(n%i == 0){
                break;
            }
        }

        if(i==n){
            return true;
        }
        return false;
    }
}
