package CodeForcesAndUSACOProblems;

import java.util.*;

//easy to increase confidence
public class CodeForcesDiv3A5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i< t;i++) {
            int n = sc.nextInt();
            Map<Character, Integer> alph = new LinkedHashMap<>();
            for (int j = 0; j < 26; j++) {
                alph.put((char)('A' + j), j + 1);
            }
            String input = sc.next();
            Map<Character, Integer> map = new LinkedHashMap<>();
            for (char c : input.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            int count = 0;
            for (char cc : map.keySet()) {
                if (map.get(cc) >= alph.get(cc)) count++;
            }
            System.out.println(count);
        }
    }
}
