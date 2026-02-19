import java.util.*;
public class CodeForces2157C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int q = sc.nextInt();
            int[] arr = new int[n];
            List<int[]> queries = new ArrayList<>();
            for (int j = 0; j < q; j++) {
                queries.add(new int[] {sc.nextInt(), sc.nextInt() - 1, sc.nextInt() - 1});
            }
            boolean[] min = new boolean[n];
            List<int[]> mexqueries = new ArrayList<>();
            for (int[] query : queries) {
                if (query[0] == 1) {
                    int l = query[1];
                    int r = query[2];
                    for (int j = l; j <= r; j++) {
                        arr[j] = k;
                        min[j] = true;
                    }
                } else mexqueries.add(query);
            }
            List<Integer> needed = new ArrayList<>();
            for (int j = 0; j < k; j++) needed.add(j);
            boolean[] mexed = new boolean[n];
            for (int[] query : mexqueries) {
                int l = query[1];
                int r = query[2];
                List<Integer> missing = new ArrayList<>();
                Set<Integer> set = new HashSet<>();
                for (int j = l; j <= r; j++) {
                    set.add(arr[j]);
                }
                for (int x : needed) {
                    if (!set.contains(x)) missing.add(x);
                }
                int p1 = 0;
                for (int j = l; j <= r; j++) {
                    if (!min[j] && !mexed[j]) {
                        arr[j] = p1 % k;
                        p1++;
                    }
                    if (arr[j] == k) arr[j] = k + 1;
                }
                for (int j = l; j <= r; j++) {
                    mexed[j] = true;
                }
            }
            for (int x : arr) System.out.print(x + " ");
            System.out.println();
        }
    }
}
