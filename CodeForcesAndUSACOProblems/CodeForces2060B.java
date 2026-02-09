import java.util.*;

public class CodeForces2060B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Set<Set<Integer>> lists = new LinkedHashSet<>();
            for (int k = 0; k < n; k++) {
                Set<Integer> list = new LinkedHashSet<>();
                for (int j = 0; j < m; j++) list.add(sc.nextInt());
                lists.add(list);
            }
            if (n == 1) {
                System.out.println(n);
            } else {
                boolean validParities = true;
                for (Set<Integer> x: lists) {
                    Set<String> parities = new HashSet<>();
                    for (int y : x) {
                        if (y % 2 == 0) parities.add("EVEN");
                        else parities.add("ODD");
                    }
                    if (parities.size() != 1) {
                        validParities = false;
                        break;
                    }
                }
                if (validParities) {
                    List<Integer> containings = new ArrayList<>();
                    for (int l = 0; l < n * m; l++) {
                        int index = 0;
                        for (Set<Integer> set : lists) {
                            if (set.contains(l)) containings.add(index + 1);
                            index++;
                        }
                    }
                    List<Integer> res  = containings.subList(0,n);
                    for (int k : res) System.out.println(k);
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}
