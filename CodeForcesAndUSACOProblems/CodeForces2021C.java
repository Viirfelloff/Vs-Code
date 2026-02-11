import java.util.*;

public class CodeForces2021C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int q = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) list.add(sc.nextInt());
            List<Integer> order = new ArrayList<>();
            for (int j = 0; j < m; j++) order.add(sc.nextInt());
            order = collapse(order);
            m = order.size();
            if (n == 1) {
                HashSet<Integer> set = new HashSet<>(order);
                if (set.size() == 1 && set.contains(list.get(0))) System.out.println("YA");
                else System.out.println("TIDAK");
            } else {
                Set<Integer> seen = new HashSet<>();
                List<Integer> ordered = new ArrayList<>();
                for (int j = 0; j < m; j++) {
                    if (!seen.contains(order.get(j))) {
                        seen.add(order.get(j));
                        ordered.add(order.get(j));
                    }
                }
                boolean valid = true;
                for (int j = 0; j < ordered.size(); j++) {
                    if (!Objects.equals(ordered.get(j), list.get(j))) {
                        valid = false;
                        break;
                    }
                }
                System.out.println(valid ? "YA" : "TIDAK");
            }
        }
    }
    public static List<Integer> collapse(List<Integer> list) {
        //members can present as many slides in a row as they want, so we can focus on one value.
        int last = Integer.MIN_VALUE;
        List<Integer> collapsed = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != last) collapsed.add(list.get(i));
            last = list.get(i);
        }
        return collapsed;
    }
}
