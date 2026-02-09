
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces2069A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> bits = new ArrayList<>();
            for (int k = 0; k < n - 2; k++) bits.add(sc.nextInt());
            boolean valid = true;
            for (int j = 1; j < bits.size() - 1; j++) {
                if (bits.get(j) == 0 && bits.get(j - 1) == 1 && bits.get(j + 1) == 1) {
                    valid = false;
                    break;
                }
            }
            if (valid) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
