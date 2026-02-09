import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces1760D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(sc.nextInt());
            }
            //first check for increasing
            boolean inc = true;
            boolean dec = true;
            for (int l = 0; l < n - 1; l++) {
                if (!(list.get(l + 1) - list.get(l) >= 0)) {
                    inc = false;
                    break;
                }
            }
            for (int m = 0; m < n- 1; m++) {
                if (!(list.get(m + 1) - list.get(m) <= 0)) {
                    dec = false;
                    break;
                }
            }
            boolean valid = true;
            int valIdx = 0;
            for (int j = 0; j < n - 1; j++) {
                if (list.get(j) - list.get(j + 1) < 0) {
                    valIdx = j;
                    break;
                }
            }
            for (int k = valIdx; k < n - 1; k++) {
                if (list.get(k) - list.get(k + 1) > 0) {
                    valid = false;
                    break;
                }
            }
            if (inc || valid) System.out.println("YES");
            else if (dec) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
