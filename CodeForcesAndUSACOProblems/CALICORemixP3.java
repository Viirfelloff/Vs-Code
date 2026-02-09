import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CALICORemixP3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<Character> chars = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                chars.add(sc.next().charAt(0));
            }
            for (int j = 0; j < m; j++) chars.add(sc.next().charAt(0));
            Collections.sort(chars);
            for (int k = 0; k < chars.size(); k++) {
                System.out.print(chars.get(k));
                if (k + 1 < chars.size()) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
