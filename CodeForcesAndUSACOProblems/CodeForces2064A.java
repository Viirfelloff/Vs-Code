import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces2064A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            List<int[]> blocks = new ArrayList<>();
            int startIdx = -1;
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '1' && startIdx == -1) {
                    startIdx = j;
                }
                if (s.charAt(j) == '0' && startIdx != -1) {
                    blocks.add(new int[]{startIdx, j - 1});
                    startIdx = -1;
                }
            }
            if (startIdx != -1) {
                blocks.add(new int[]{startIdx, n - 1});
            }
            if (blocks.size() == 1 && blocks.get(0)[1] == n - 1) System.out.println(1);
            else if (blocks.isEmpty()) System.out.println(0);
            else System.out.println(blocks.size() + 1);
        }
    }
}
