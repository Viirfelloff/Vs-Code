import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForcesDiv2CC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            int tz = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') tz++;
            }
            List<Integer> idx = new ArrayList<>();
            //count the stuff out of place idk bro
            for (int z = 0; z < tz; z++) {
                if (s.charAt(z) == '1') idx.add(z + 1);
            }
            for (int j = tz; j < n; j++) {
                if (s.charAt(j) == '0') idx.add(j + 1);
            }
            //this solution seems way too trivial
            if (idx.isEmpty()) System.out.println("Bob");
            else {
                System.out.println("Alice");
                System.out.println(idx.size());
                for (int x : idx) {
                    System.out.println(x);
                }
                System.out.println();
            }
        }
    }
}
