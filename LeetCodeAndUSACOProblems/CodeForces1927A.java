

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeForces1927A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            List<Integer> blacks = new ArrayList<>();
            for (int m = 0; m < s.length(); m++) {
                if (s.charAt(m) == 'B') blacks.add(m);
            }
            System.out.println(Collections.max(blacks) - Collections.min(blacks) + 1);
        }
    }
}
