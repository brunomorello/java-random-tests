import java.util.HashMap;
import java.util.Map;

public class MapsTests {
    public static void main(String[] args) {
        Map<String, String> x = new HashMap<>();
        x.put("1", "1");
        x.put("2", "1");
        x.put("3", "1");

        if (true && false) {
            System.out.println("true");
        }

        if (true && false || true) {
            System.out.println("true2");
        }

        enum Cats{A, B, C};

        for (Map.Entry<String, String> x1: x.entrySet()) {
            System.out.println(x1.getValue() + Cats.A);
        }
    }
}
