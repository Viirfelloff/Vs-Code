package LeetCodeAndUSACOProblems;

import java.util.*;
//les go
// too easy
public class CodeForcesDiv4C3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> strengths = new ArrayList<>();
            List<Integer> sorted = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                int xx = sc.nextInt();
                strengths.add(xx);
                sorted.add(xx);
            }
            Map<Integer, Integer> res = new LinkedHashMap<>();
            Collections.sort(sorted);
            for (int j = 0; j < strengths.size(); j++) {
                if (j < strengths.size() - 1) {
                    res.put(sorted.get(j), sorted.get(j) - sorted.getLast());
                } else {
                    res.put(sorted.get(j), sorted.get(j) - sorted.get(j - 1));
                }
            }
            for (int x : strengths) System.out.println(res.get(x));
        }
    }
}
