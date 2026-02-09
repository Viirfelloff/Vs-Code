import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces1878a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) list.add(sc.nextInt());
            if (list.contains(k)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
