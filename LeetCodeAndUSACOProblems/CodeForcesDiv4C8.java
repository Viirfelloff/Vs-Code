package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Scanner;

public class CodeForcesDiv4C8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();
            int m = sc.nextInt();
            List<int[]> events = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int[] event = new int[]{sc.nextInt(), sc.nextInt()};
                events.add(event);
            }
            List<Integer> between = new ArrayList<>();
            between.add(events.get(0)[0]);
            for (int j = 0; j < events.size() - 1; j++) {
                between.add((events.get(j)[1] - events.get(j + 1)[0]) - 1);
            }
            between.add(m - events.getLast()[1]);
            boolean found = false;
            for (int xx : between) {
                if (xx >= s) {
                    found = true;
                    break;
                }
            }
            if (found) System.out.println("YES");
            else System.out.println("FALSE");
        }
    }
}
