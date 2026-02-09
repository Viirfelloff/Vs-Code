package CodeForcesAndUSACOProblems;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CodeForcesDiv3A6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            List<Integer> digits = new ArrayList<>();
            String s = Integer.toString(x);
            for (char c : s.toCharArray()) {
                int y = Character.getNumericValue(c);
                digits.add(y);
            }
            System.out.println(Collections.min(digits));
        }
    }
}
