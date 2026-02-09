package CodeForcesAndUSACOProblems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

//easy ash
public class CodeForcesDiv4B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> map = new LinkedHashMap<>();
            for (int j = 0; j < 3; j++) {
                char[] row = sc.next().toCharArray();
                for (char c : row) {
                    map.put(c, map.getOrDefault(c,0) + 1);
                }
            }
            for (char b : map.keySet()) {
                if (map.get(b) != 3 && b != '?') System.out.println(b);
            }
        }
    }
}
