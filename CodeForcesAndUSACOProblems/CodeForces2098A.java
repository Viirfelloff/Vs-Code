import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeForces2098A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String I = sc.next();
            List<Integer> sorted = new ArrayList<>();
            for (int k = 0; k < 10; k++) sorted.add(I.charAt(k) - '0');
            Collections.sort(sorted);
            StringBuilder sb = new StringBuilder();
            for (int j = 9; j >= 0; j--) {
                for (int x : sorted) {
                    if (x >= j) {
                        sb.append(x);
                        sorted.remove(Integer.valueOf(x));
                        break;
                    }
                }
            }
            System.out.println(sb);
        }
    }
}
