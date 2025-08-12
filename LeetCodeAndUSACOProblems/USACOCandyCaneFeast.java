package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Revisit

public class USACOCandyCaneFeast {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> heights = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            heights.add(sc.nextInt());
        }
        List<Integer> canes = new ArrayList<>();
        for (int k = 0; k < m; k++) {
            canes.add(sc.nextInt());
        }
        for (int j = 0; j < canes.size(); j++) {
            int base = 0;
            for (int b = 0; b < heights.size(); b++) {
                if (base <= heights.get(b)) {
                    int canEat = Math.min(heights.get(b) - base, canes.get(j));
                    base += canEat;
                    canes.set(j, canes.get(j) - canEat);
                    heights.set(b, heights.get(b) + canEat);
                    if (canes.get(j) == 0) break;
                }
            }
        }
        for (int x : heights) {
            System.out.println(x);
        }
    }
}
