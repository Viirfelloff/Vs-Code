import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces2060D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Long> list = new ArrayList<>();
            boolean valid = true;
            for (int k = 0; k < n; k++) list.add(sc.nextLong());
            for (int j = 0; j < n - 1; j++) {
                if (list.get(j) <= list.get(j + 1)) {
                    long temp = list.get(j);
                    list.set(j, 0L);
                    list.set(j + 1, list.get(j + 1) - temp);
                } else {
                    valid = false;
                    break;
                }
            }
            if (valid) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
