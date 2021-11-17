
import java.util.Scanner;

public class Cubes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String word = scanner.nextLine();
            
            if (word.equals("end")) {
                break;
            }
            
            try {
                int result = Integer.parseInt(word);
                if (result > 0) {
                    System.out.println(result * result * result);
                } else {
                    System.out.println(result);
                }
            } catch (Exception e) {
                System.out.println(word);
            }
        }
    }
}
