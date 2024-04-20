package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentGradeAnalyzer{
    static void analyzeGrade(String filePath) throws Exception{
        Path path = Paths.get(filePath);
        Map<String, Integer> hm = new HashMap<>();
        if(Files.exists(path)) {
            try (Stream<String> lines = Files.lines(path)) {
                hm = lines
                        .map(line -> line.split(","))
                        .collect(Collectors.toMap(line -> line[0], line -> Integer.parseInt(line[1])));
            }
        }
        System.out.println("File does not exist");

        ArrayList<Integer> grades = new ArrayList<>();
        for(Map.Entry<String, Integer> result : hm.entrySet()){
            grades.add(result.getValue());
        }
        //Calculate statistics
        //average
        OptionalDouble avg = grades.stream()
                            .mapToInt(Integer::intValue)
                            .average();

        //Highest grade
        OptionalInt max = grades.stream()
                        .mapToInt(Integer::intValue)
                        .max();

        //Lowest Grade
        OptionalInt min = grades.stream()
                    .mapToInt(Integer::intValue)
                    .min();

        //no. of students passed
        long pass = grades.stream()
                    .mapToInt(Integer::intValue)
                    .filter(val -> val>=30)
                    .count();

        //no. of students failed
        long fail = grades.stream()
                    .mapToInt(Integer::intValue)
                    .filter(val -> val<30)
                    .count();

        System.out.println("STATISTICS:");
        System.out.println("- Average grade : "+avg);
        System.out.println("- Highest grade : "+max);
        System.out.println("- Lowest grade : "+min);
        System.out.println("- Number of students passed : "+pass);
        System.out.println("- Number of students failed : "+fail);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE PATH OF CSV FILE: ");     //xmpl.csv
        String csvFile = sc.next();
        analyzeGrade(csvFile);
    }
}
