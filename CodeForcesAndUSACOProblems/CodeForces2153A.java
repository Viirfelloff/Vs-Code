import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CodeForces2153A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            Set<Integer> set = new HashSet<>();
            int n = sc.nextInt();
            for (int j = 0;j < n; j++) {
                set.add(sc.nextInt());
            }
            System.out.println(set.size());
        }
    }
}
