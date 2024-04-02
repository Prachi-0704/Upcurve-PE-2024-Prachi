import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         //QUESTION 1
        System.out.println("ENTER THE MONTH:");
        int month = sc.nextInt();
        System.out.println("ENTER THE YEAR:");
        int year = sc.nextInt();
        printCalender(month, year);
        System.out.println("\n\n");

        /*//QUESTION 2
        System.out.println("ENTER THE NUMBER:");
        int num = sc.nextInt();
        NumToWords.inWords(num);
        */

        //QUESTION 3
        Cylinder[] circles = {
                new Cylinder(12, 34),
                new Cylinder(12.34, 10.0),
                new Cylinder(12.34, 10.0, "blue")
        };

        for(int i=0; i<circles.length; i++){
            System.out.println(circles[i].toString());;
            System.out.print("Area: "+circles[i].getArea());
            System.out.println("\t Volume: "+circles[i].getVolume());
            System.out.println();
        }


        //QUESTION 4
        System.out.println("ENTER A SENTENCE:");
        sc.nextLine();
        String sentence = sc.nextLine();
        sentence = ReverseSentence.reverseByWords(sentence);
        System.out.println(sentence);
    }

    public static void printCalender(int month, int year){
        int month_days;

        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            month_days = 31;
        }
        else if(month == 4 || month == 6 || month == 9 || month == 11){
            month_days = 30;
        }
        else if(month == 2){
            if(year%4 == 0) {
                month_days = 29;
            }else{
                month_days = 28;
            }
        }
        else{
            System.out.println("INVALID");
            return;
        }

        int q = 1;
        int m = month;
        int K = year % 100;
        int J = year / 100;

        int ans = (q + (13 * (m + 1) / 5) + K + (K / 4) + (J / 4) - (2 * J)) % 7;


        System.out.println("Su\tMo\tTu\tWe\tTh\tFr\tSa");

        int day = 1;

        for(int j=0; j<ans-1; j++){
            System.out.print("\t");
        }
        for(int i=0; i<month_days; i++){
            System.out.print(day+"\t");
            if((day+ans-1)%7 == 0){
                System.out.println();
            }
            day++;
        }

    }
}

class Circle{
    double radius = 1.0;
    String color = "red";

    Circle(){

    }

    Circle(double radius){
        this.radius = radius;
    }

    Circle(double radius, String color){
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea(){
        return (Math.PI)*radius*radius;
    }

    @Override
    public String toString(){
        return "Circle[radius = "+radius+", color = "+color+"]";
    }
}

class Cylinder extends Circle{
    double height = 1.0;

    Cylinder(){

    }

    Cylinder(double radius){
        super.radius = radius;
    }

    Cylinder(double radius, double height){
        super.radius = radius;
        this.height = height;
    }

    Cylinder(double radius, double height, String color){
        super.radius = radius;
        this.height = height;
        super.color = color;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume(){
        return (Math.PI)*radius*radius*height;
    }

    @Override
    public String toString() {
        return "Cylinder[radius = "+radius+",height = "+height+", color = "+color+"]";
    }
}

class ReverseSentence {
    public static String reverseByWords(String sentence){
        String[] words = sentence.split("\\s+");

        sentence = "";

        int n = words.length;

        for(int i=0; i<n-1; i++){
            sentence += words[n-1-i]+" ";
        }
        sentence += words[0];
        return sentence;
    }
}