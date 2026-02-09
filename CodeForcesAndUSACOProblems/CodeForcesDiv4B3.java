package CodeForcesAndUSACOProblems;

import java.util.*;
//too easy
public class CodeForcesDiv4B3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i< t; i++) {
            int n = sc.nextInt();
            int counter = 1;
            int last = -1;
            List<Integer> lengths = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for (int k=0; k <n; k++) {
                int x = sc.nextInt();
                if (x == last && x == 0) {
                    counter++;
                } else {
                    lengths.add(counter);
                    counter = 1;
                }
                last = x;
                set.add(x);
            }
            if (!set.contains(0)) {
                System.out.println("0");
            } else {
                System.out.println(Collections.max(lengths));
            }
        }
    }
}
