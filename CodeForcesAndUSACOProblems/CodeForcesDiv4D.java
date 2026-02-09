package CodeForcesAndUSACOProblems;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
//les go are we him or him
public class CodeForcesDiv4D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i< t; i++) {
            Set<String> set = new LinkedHashSet<>();
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                set.add(sc.next());
            }
            StringBuilder res = new StringBuilder();
            for (String s : set) {
                boolean found = false;
                for (int m = 1; m < s.length(); m++) {
                    String one = s.substring(0,m);
                    String two = s.substring(m);
                    if (set.contains(one) && set.contains(two)) {
                        found = true;
                        break;
                    }
                }
                if (found) res.append(1);
                else res.append(0);
            }
            System.out.println(res.toString());
        }
    }
}
