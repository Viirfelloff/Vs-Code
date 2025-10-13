import java.util.*;
//TODO: IMPLEMENT 10/14
public class CodeForces2121C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<List<Integer>> matrix = new ArrayList<>();
            int max = -1;
            for (int j = 0; j < n; j++) {
                List<Integer> set = new ArrayList<>();
                for (int k = 0; k < m; k++) {
                    int x = sc.nextInt();
                    if (x > max) max = x;
                    set.add(x);
                }
                matrix.add(set);
            }
            Set<Integer> rowsMax = new HashSet<>();
            Set<Integer> colsMax = new HashSet<>();

        }
    }
}
