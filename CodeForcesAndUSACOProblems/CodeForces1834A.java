import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces1834A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            int neg = 0;
            int pos = 0;
            int ops = 0;
            for (int k = 0; k < n; k++) {
                int x = sc.nextInt();
                list.add(x);
                if (x == -1) neg++;
                else pos++;
            }
            int sum = neg * -1 + pos;
            while (sum < 0) {
                neg--;
                pos++;
                ops++;
                sum = neg *-1 + pos;
            }
            if (neg % 2 != 0) {
                ops++;
            }
            System.out.println(ops);
        }
    }
}
