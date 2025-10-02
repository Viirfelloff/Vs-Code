
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces2091C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            if (n % 2 == 0) System.out.println(-1);
            else {
                int mid = (n + 1) / 2;
                List<Integer> left = new ArrayList<>();
                List<Integer> right = new ArrayList<>();

                for (int l = 1; l < mid; l++) left.add(l);
                for (int m = mid + 1; m <= n; m++) right.add(m);

                List<Integer> result = new ArrayList<>();
                int size = Math.min(left.size(), right.size());
                for (int b = 0; b < size; b++) {
                    result.add(right.get(b));
                    result.add(left.get(b));
                }

                // Add remaining numbers if any
                for (int p = size; p < right.size(); p++) result.add(right.get(p));
                for (int h = size; h < left.size(); h++) result.add(left.get(h));

                result.add(mid); // add anchor

                // Print permutation
                for (int num : result) System.out.print(num + " ");
                System.out.println();
            }
        }
    }
}
