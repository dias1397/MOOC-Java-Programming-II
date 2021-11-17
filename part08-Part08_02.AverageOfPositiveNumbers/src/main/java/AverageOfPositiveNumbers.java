
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();
        
        while (input != 0) {
            if(input > 0) {
                numbers.add(input);
            }
            input = scanner.nextInt();
        }
        
        if (numbers.isEmpty()) {
            System.out.println("Cannot calculate the average");
        } else {
            double total = numbers.stream().reduce(0, Integer::sum);
            System.out.println(total/numbers.size());
        }
    }
}
