import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class CodeForces1815A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Long> list = new ArrayList<>();
            for (int j = 0; j < n; j++) list.add(sc.nextLong());
            if (n == 2) {
                if (list.get(0) <= list.get(1)) System.out.println("YES");
                else System.out.println("NO");
            } else if (n == 1) {
                System.out.println("YES");
            } else {
                List<Long> sorted = new ArrayList<>(list);
                Collections.sort(sorted);
                for (int j = 0; j < n - 2; j++) {
                    if (list.get(j) - list.get(j + 1) > 0) {
                        long diff = list.get(j) - list.get(j + 1);
                        list.set(j + 1, list.get(j + 1) + diff);
                        list.set(j + 2, list.get(j + 2) + diff);
                    }
                }
                if (sorted.equals(list)) System.out.println("YES");
                else {
                    if (n % 2 == 0) System.out.println("NO");
                    else System.out.println("YES");
                }
            }
        }
    }
}
