
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeForces1822A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<Integer> l1 = new ArrayList<>();
            List<Integer> l2 = new ArrayList<>();
            List<Integer> candidateInterest = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                l1.add(sc.nextInt());
            }
            for (int b = 0; b < n; b++) {
                l2.add(sc.nextInt());
            }
            int bestIndex = -1;
            int bestValue = -1;

            for (int l = 0; l < n; l++) {
                int totalTime = l1.get(l) + l; // watch + skips
                if (totalTime <= m && l2.get(l) > bestValue) {
                    bestValue = l2.get(l);
                    bestIndex = l + 1; // 1-based index
                }
            }
            System.out.println(bestIndex);

        }
    }
}
