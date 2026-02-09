import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces2167B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            String name = sc.next();
            List<Character> sList = new ArrayList<>();
            for (char c: s.toCharArray()) sList.add(c);
            boolean valid = true;
            for (int j = 0; j < n; j++) {
                if (!sList.contains(name.charAt(j))) {
                    valid = false;
                    break;
                } else {
                    sList.remove(Character.valueOf(name.charAt(j)));
                }
            }
            if (valid) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
