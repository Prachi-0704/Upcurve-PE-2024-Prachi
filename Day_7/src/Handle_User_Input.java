import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Handle_User_Input {
    public void user(){

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> validInputs = new ArrayList<>();
        ArrayList<String> invalidInputs = new ArrayList<>();
        int totalInputs = 0;
        int totalValidInputs = 0;
        int totalInvalidInputs = 0;
        int sumOfValidInputs = 0;

        while (true) {
            System.out.println("Enter an integer (type 'NO' to stop): ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("NO")) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                totalInputs++;
                totalValidInputs++;
                sumOfValidInputs += number;
                validInputs.add(number);
            } catch (NumberFormatException e) {
                totalInputs++;
                totalInvalidInputs++;
                invalidInputs.add(input);
                System.out.println("Invalid input. Please enter a valid integer.");
            }

            // Consume newline character
            scanner.nextLine();

            System.out.println("Do you want to continue? (YES/NO)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("NO")) {
                break;
            }
        }

        // Display Summary
        System.out.println("Summary:");
        System.out.println("Total number of inputs: " + totalInputs);
        System.out.println("Number of valid integers: " + totalValidInputs);
        System.out.println("Number of invalid inputs: " + totalInvalidInputs);
        System.out.println("Sum of all valid integers: " + sumOfValidInputs);
        System.out.println("List of valid integers entered: " + validInputs);
        System.out.println("List of all invalid inputs entered: " + invalidInputs);

    }
}
