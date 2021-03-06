
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int container1 = 0;
        int container2 = 0;


        while (true) {
            System.out.println("First: " + container1 + "/100");
            System.out.println("Second: " + container2 + "/100");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            
            String action = input.split(" ")[0];
            int amount = Integer.valueOf(input.split(" ")[1]);
            
            if (amount < 0) {
                continue;
            }
            
            switch(action) {
                case "add": 
                    container1 += amount;
                    if (container1 > 100) {
                        container1 = 100;
                    }
                    break;
                case "move":
                    if (container1 > 0) {
                        if (container1 < amount) {
                            amount = container1;
                        }
                        container1 -= amount;
                        container2 += amount;
                        if (container2 > 100) {
                            container2 = 100;
                        }
                    }
                    break;
                case "remove":
                    container2 -= amount;
                    if (container2 < 0) {
                        container2 = 0;
                    }
                    break;
                default:
            }
        }
    }

}
