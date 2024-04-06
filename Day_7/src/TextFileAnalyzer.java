import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextFileAnalyzer {

    void readFile() {
        ArrayList<String> lines;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("ENTER THE FILE NAME:");
            String fileName = sc.nextLine();
            File reader = new File(fileName);

            String st;
            lines = new ArrayList<>();
            ;
            BufferedReader br = new BufferedReader(new FileReader(reader));

            while ((st = br.readLine()) != null) {
                lines.add(st);
                System.out.println(st);
            }
            br.close(); // Close the BufferedReader after reading

            System.out.println("LONGEST LINE:");
            System.out.println(findLongestLine(lines));

            System.out.println("SHORTEST LINE:");
            System.out.println(findShortestLine(lines));

            System.out.println("WORD COUNT FOR EACH LINE: ");
            ArrayList<Integer> wordCounts = countWords(lines);
            int j = 1;
            for (int count : wordCounts) {
                System.out.print("Line "+j+" : ");
                System.out.println(count);
                j++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //C:\Users\RAJESH PATIL\Desktop\IPR Notes(16_09_23).txt
    String findLongestLine(ArrayList<String> lines){
        int n = lines.size();
        int max = 0;
        String ans = "";
        for(int i=0; i<n; i++){
            int len = lines.get(i).length();
            if(len > max){
                ans = lines.get(i);
                max = len;
            }
        }
        return ans;
    }

    String findShortestLine(ArrayList<String> lines){
        int n = lines.size();
        int min = 0;
        String ans = "";
        for(int i=0; i<n; i++){
            int len = lines.get(i).length();
            if(len < min){
                ans = lines.get(i);
                min = len;
            }
        }
        return ans;
    }

    ArrayList<Integer> countWords(ArrayList<String> lines){
         ArrayList<Integer> count = new ArrayList<>();
        int n = lines.size();
        for(int i=0; i<n; i++){
            String[] words = lines.get(i).split("\\s+");
            count.add(words.length);
        }
        return count;
    }

}
