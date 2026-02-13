import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces1556B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Long> list = new ArrayList<>();
            int evens = 0;
            int odds = 0;
            for (int j = 0; j < n; j++) {
                long x = sc.nextLong();
                if (x % 2 == 0) evens++;
                else odds++;
                list.add(x);
            }
            if (Math.abs(evens - odds) > 1) System.out.println(-1);
            else {
                List<Integer> evenss = new ArrayList<>();
                for (int ii = 0; ii < n; ii++) {
                    if (list.get(ii) % 2 == 0) evenss.add(ii);
                }
                long answer = Long.MAX_VALUE;
                if (n % 2 == 0 || evenss.size() > n / 2) {
                    long cost = 0;
                    for (int ii = 0; ii < evenss.size(); ii++) {
                        cost += Math.abs(evenss.get(ii) - 2L * ii);
                    }
                    answer = Math.min(answer, cost);
                }

                if (n % 2 == 0 || evenss.size() < n / 2 + 1) {
                    long cost = 0;
                    for (int ii = 0; ii < evenss.size(); ii++) {
                        cost += Math.abs(evenss.get(ii) - (2L * ii + 1));
                    }
                    answer = Math.min(answer, cost);
                }
                System.out.println(answer);
            }
        }
    }
}
