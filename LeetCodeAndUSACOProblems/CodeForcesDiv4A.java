package LeetCodeAndUSACOProblems;

import java.util.*;

//easy ash
public class CodeForcesDiv4A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i<t; i++) {
            List<Integer> nums = new ArrayList<>();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            nums.add(a);
            nums.add(b);
            nums.add(c);
            Map<Integer, Integer> map = new LinkedHashMap<>();
            for (int x : nums) {
                map.put(x, map.getOrDefault(x,0) + 1);
            }
            for (int y : map.keySet()) {
                if (map.get(y) == 1) {
                    System.out.println(y);
                    break;
                }
            }
        }
    }
}
