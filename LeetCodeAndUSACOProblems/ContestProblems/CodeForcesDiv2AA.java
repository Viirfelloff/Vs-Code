import java.util.*;

public class CodeForcesDiv2AA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            Map<Integer, Integer> mp = new LinkedHashMap<>();

            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                list.add(x);
            }
            List<Integer> sorted = new ArrayList<>(list);
            //check both cases
            Collections.sort(sorted);
            for (int j = 0; j < n; j++) {
                mp.put(sorted.get(j), j);
            }
            //check if diff
            boolean valid = true;
            for (int j = 0; j < n - 1; j++) {
                if ((mp.get(list.get(j)) - mp.get(list.get(j + 1))) % 2 == 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
