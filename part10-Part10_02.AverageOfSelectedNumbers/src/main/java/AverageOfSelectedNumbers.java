
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Write your program here
        List<String> list = new ArrayList<>();
        System.out.println("Input numbers, type \"end\" to stop.");
        while (true) {
           String input = scanner.nextLine();
           if (input.equals("end")) {
               break;
           }
           list.add(input);
        }

        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String option = scanner.nextLine();
        double average;
        if (option.equals("n")) {
            average = list.stream()
                    .mapToInt(Integer::valueOf)
                    .filter(n -> n < 0)
                    .average()
                    .getAsDouble();
            System.out.println("Average of the negative numbers: " + average);
        } else if(option.equals("p")) {
            average = list.stream()
                    .mapToInt(Integer::valueOf)
                    .filter(n -> n > 0)
                    .average()
                    .getAsDouble();
            System.out.println("Average of the positive numbers: " + average);
        }
        
    }
}
