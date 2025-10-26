import java.util.*;

public class CodeForces2144A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            int[] prefix = new int[n];
            int[] suffix = new int[n];
            int global = 0;

            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                list.add(x);
                global += x;
            }

            int prefixSum = 0;
            for (int j = 0; j < n; j++) {
                prefixSum += list.get(j);
                prefix[j] = prefixSum;
            }

            int suffixSum = 0;
            for (int j = n - 1; j >= 0; j--) {
                suffixSum += list.get(j);
                suffix[j] = suffixSum;
            }

            int lres = -1, rres = -1;
            outer:
            for (int l = 0; l < n - 2; l++) {
                for (int m = l + 1; m < n - 1; m++) {
                    int a = prefix[l];
                    int c = suffix[m + 1];
                    int b = global - a - c;

                    Set<Integer> set = new HashSet<>();
                    set.add(a % 3);
                    set.add(b % 3);
                    set.add(c % 3);

                    if (set.size() == 1 || set.size() == 3) {
                        lres = l;
                        rres = m;
                        break outer;
                    }
                }
            }

            if (lres == -1) {
                System.out.println("0 0");
            } else {
                System.out.println((lres + 1) + " " + (rres + 1));
            }
        }
    }
}
