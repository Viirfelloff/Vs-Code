import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class USACOStatic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        List<Integer> pf = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            sum += x;
            pf.add(sum);
        }
        for (int i = 0; i < q; i++) {
            int lower = sc.nextInt();
            int upper = sc.nextInt() - 1;
            System.out.println(pf.get(upper) - pf.get(lower));
        }
    }
}
