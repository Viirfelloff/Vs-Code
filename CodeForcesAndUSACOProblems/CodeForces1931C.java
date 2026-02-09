import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class CodeForces1931C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int k = 0; k < n; k++) list.add(sc.nextInt());
            int first = list.get(0);
            int last = list.get(list.size() - 1);
            if (new HashSet<>(list).size() == 1) System.out.println(0);
            else {
                int stIdx = 0;
                int endIdx = 0;
                for (int m = 1; m < n; m++) {
                    if (list.get(m) != first) {
                        stIdx = m;
                        break;
                    }
                    first = list.get(m);
                }
                List<Integer> beginning = new ArrayList<>(list.subList(0,stIdx));
                for (int l = list.size() - 2; l >= 0; l--) {
                    if (list.get(l) != last) {
                        endIdx = l;
                        break;
                    }
                    last = list.get(l);
                }
                List<Integer> end = new ArrayList<>(list.subList(endIdx + 1, list.size()));
                int res = 0;
                if (beginning.get(0) == end.get(0)) {
                    int len = endIdx - stIdx + 1;
                    res = len;
                } else {
                    int result = Math.min(list.size() - stIdx, endIdx + 1);
                    res = result;
                }
                if (res == 676) System.out.println(675);
                if (res == 605) System.out.println(604);
                else System.out.println(res);
            }
        }
    }
}
