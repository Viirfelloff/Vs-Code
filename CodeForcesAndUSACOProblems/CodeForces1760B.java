import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeForces1760B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> pos = new ArrayList<>();
            List<Character> alph = new ArrayList<>();
            for (int j = 0; j < 26; j++) {
                alph.add((char)('a' + j));
            }
            String s = sc.next();
            for (char c : s.toCharArray()) {
                pos.add(alph.indexOf(c));
            }
            System.out.println(Collections.max(pos) + 1);
        }
    }
}
