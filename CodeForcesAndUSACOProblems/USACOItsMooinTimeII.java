import java.util.*;

public class USACOItsMooinTimeII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        Map<Integer, List<Integer>> pos = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[i] = x;
            pos.computeIfAbsent(x, k -> new ArrayList<>()).add(i);
        }

        int moos = 0;
        Set<Integer> distinct = pos.keySet();

        for (int x : distinct) {
            int lastX = pos.get(x).get(pos.get(x).size() - 1);
            for (int y : distinct) {
                if (y == x) continue;
                List<Integer> yPos = pos.get(y);
                // Count how many occurrences of y are after lastX
                int countAfter = 0;
                for (int p : yPos) {
                    if (p > lastX) countAfter++;
                }
                if (countAfter >= 2) moos++;
            }
        }

        System.out.println(moos);
    }
}
