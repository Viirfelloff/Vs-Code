package CodeForcesAndUSACOProblems;

import java.util.*;
//we have the logic but constraints fail because of 100 trillion iterations.
//revisit
public class USACOHungryCow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int eaten = 0;
        Map<Integer, Integer> map1 = new LinkedHashMap<>();
        for (int j = 0; j < n; j++) {
            int day = sc.nextInt();
            int bales = sc.nextInt();
            map1.put(day, bales);
        }
        int bale = 0;
        for (int l = 1; l <= k; l++) {
            if (map1.containsKey(l)) {
                bale += map1.get(l);
            }
            if (bale > 0) {
                eaten++;
                bale--;
            }
        }
        System.out.println(eaten);
    }
}
