
import java.util.*;

public class CodeForces2133A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            for (int k = 0; k < n; k++) {
                int x = sc.nextInt();
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
            boolean valid = false;
            for (int y : map.values()) {
                if (y >= 2) {
                    valid = true;
                    break;
                }
            }
            if (valid) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
