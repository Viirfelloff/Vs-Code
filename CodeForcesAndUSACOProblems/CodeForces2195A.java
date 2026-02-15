import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class CodeForces2195A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                set.add(sc.nextInt());
            }
            if (set.contains(67) && set.contains(1)) System.out.println("YES");
            else  System.out.println("NO");
        }
    }
}
