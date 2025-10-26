import java.util.*;

public class CodeForces2137D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> occ = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                occ.add(sc.nextInt());
            }
            //implementation: make a new element for each thing going over the limit
            //ex 2 1s = 2 elements occur once. 4 2s. two elements occur twice.
            //then using the order output an array following the constraints.
            Map<Integer, Integer> occocc = new HashMap<>();
            for (int x : occ) {
                occocc.put(x, occocc.getOrDefault(x, 0) + 1);
            }
            boolean valid = true;

        }
    }
}
