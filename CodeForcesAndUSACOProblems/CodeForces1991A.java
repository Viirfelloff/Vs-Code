import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeForces1991A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) list.add(sc.nextInt());
            List<Integer> copy = new ArrayList<>(list);
            Collections.sort(copy);
            int idx = copy.size() - 1;
            boolean found = false;
            int res = -1;
            while (!found) {
                boolean evenOcc = false;
                List<Integer> occ = indexOf(list, copy.get(idx));
                for (int x : occ) {
                    if (x % 2 == 0) {
                        evenOcc = true;
                        break;
                    }
                }
                if (evenOcc) {
                    res = copy.get(idx);
                    found = true;
                }
                idx--;
            }
            System.out.println(res);
        }
    }
    public static List<Integer> indexOf(List<Integer> l, int target) {
        List<Integer> idxs = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) == target) idxs.add(i);
        }
        return idxs;
    }
}
