import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeForces2163A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int k = 0; k < n; k++) list.add(sc.nextInt());
            Collections.sort(list);
            boolean valid = true;
            for (int j = 0; j < n - 1; j++) {
                if (j % 2 != 0) {
                    if (list.get(j) != list.get(j + 1)) {
                        valid = false;
                        break;
                    }
                }
            }
            if (valid) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
