import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CodeForces1759B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            Set<Integer> list = new HashSet<>();
            for (int j = 0; j < n; j++) list.add(sc.nextInt());
            int sum1 = 0;
            int newN = Collections.max(list);
            for (int kk = 1; kk <= newN; kk++) {
                if (!list.contains(kk)) sum1 += kk;
            }
            if (sum1 > k) System.out.println("NO");
            else if (sum1 == k) System.out.println("YES");
            else {
                int currentN = newN + 1;
                int currentSum = sum1;
                while (currentSum < k) {
                    currentSum += currentN;
                    currentN++;
                }
                if (currentSum == k) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}
