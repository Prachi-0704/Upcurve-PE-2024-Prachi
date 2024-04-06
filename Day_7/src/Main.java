import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //ASSIGNMENT 1 1
        System.out.println("H A N D L I N G   U S E R   I N P U T");
        Handle_User_Input q1 = new Handle_User_Input();
        q1.user();
//        Scanner sc = new Scanner(System.in);
//        sc.next();

        //ASSIGNMENT 2
        System.out.println("\n\n\nT E X T   F I L E   A N A L Y Z E R");
        TextFileAnalyzer tfa = new TextFileAnalyzer();
        tfa.readFile();


        //ASSIGNMENT 3
        System.out.println("\n\n\nB U I L D I N G   S O R T I N G   L I B R A R Y");
        int[] arr = {3, 2, 4, 1};

        System.out.println("\n\nBUBBLE SORT");

        System.out.print("BEFORE: ");
        for(int i : arr) {
            System.out.print(i+", ");
        }

        BubbleSort bs = new BubbleSort();
        bs.sort(arr);

        System.out.print("\nAFTER: ");
        for(int i : arr) {
            System.out.print(i+", ");
        }

        int arr2[] = {12, 6, 3, 83};

        System.out.println("\n\nSELECTION SORT");

        System.out.print("BEFORE: ");
        for(int i : arr2) {
            System.out.print(i+", ");
        }

        SelectionSort ss = new SelectionSort();
        ss.sort(arr2);

        System.out.print("\nAFTER: ");
        for(int i : arr2) {
            System.out.print(i+", ");
        }

        int arr3[] = {152, 236, 53, 83};

        System.out.println("\n\nMERGE SORT");

        System.out.print("BEFORE: ");
        for(int i : arr3) {
            System.out.print(i+", ");
        }

        MergeSort ms = new MergeSort();
        ms.sort(arr3);

        System.out.print("\nAFTER: ");
        for(int i : arr3) {
            System.out.print(i+", ");
        }
    }

}