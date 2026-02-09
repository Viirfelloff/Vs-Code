import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces2059B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            List<Long> list = new ArrayList<>();
            for (int j = 0; j < n; j++) list.add(sc.nextLong());
            //if k = n, answer is unique. otherwise, iterate over all starting positions of second subarray that are allowed based off of given k.
            //if only 1s, answer is 2. otherwise, answer is 1.
            if (k == n) {
                List<Long> res = new ArrayList<>();
                for (int m = 1; m < n; m += 2) res.add(list.get(m));
                System.out.println(minCost(res));
            } else {
                //start = 1
                int lastPos = n - k + 1;
                boolean notOne = false;
                for (int b = 1; b <= n - k + 1; b++) {
                    if (list.get(b) != 1) {
                        notOne = true;
                        break;
                    }
                }
                if (notOne) System.out.println(1);
                else System.out.println(2);
            }
        }
    }
    public static int minCost(List<Long> list) {
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j) != j + 1) return j + 1;
        }
        return list.size() + 1;
    }
}
