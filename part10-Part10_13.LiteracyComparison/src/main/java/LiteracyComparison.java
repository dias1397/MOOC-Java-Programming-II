
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        try {
            List<String> rows = Files.lines(Paths.get("literacy.csv"))
                    .collect(Collectors.toCollection(ArrayList::new));
            
            rows.stream()
                    .map(r -> r.split(","))
                    .sorted((r1, r2) -> {
                        return r1[5].compareTo(r2[5]);
                    })
                    .forEach(r -> System.out.println(r[3] + " (" + r[4] + "), " + r[2].split(" ")[1] + ", " + r[5]));
            
        } catch (IOException e) {
        
        }
    }
}
