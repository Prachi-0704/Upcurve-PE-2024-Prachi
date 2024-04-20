/*Write a Java program that reads a text file and counts the frequency of each word in the file.
The program should then display the top N most frequent words along with their frequencies.*/
package Model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class WordFreqCounter {

    public static void wordFreqCount(String fileName, int maxSize) throws IOException {

        String[] ans = new String[maxSize];

        //1. Read the contents of a text file (input.txt) and tokenize it into words.

        String str = "";

        try(BufferedReader in = new BufferedReader(new FileReader(fileName))){
            int c;
            while ((c = in.read()) != -1) {
                str += (char)c;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        String[] arr = str.split(" ");

        //2. Count the frequency of each word using Java Streams.

        // Sort the map by frequency in descending order
        Arrays.stream(arr)
                .collect(Collectors.groupingBy(string->string.toLowerCase(Locale.ROOT),Collectors.counting()))//Ignore case sensitivity while counting words
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String,Long>comparingByValue().reversed())
                .limit(maxSize)         //Display the top N most frequent words
                .forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE FILE PATH:");
        String fileName = sc.nextLine();
        System.out.println("ENTER THE MAX SIZE: ");
        int maxSize = sc.nextInt();
        WordFreqCounter.wordFreqCount(fileName, maxSize);
    }

}
