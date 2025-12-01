import java.awt.*;
import java.util.*;
import java.util.List;

public class CodeForces2085B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            int zeroCount = 0;
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                list.add(x);
                if (x == 0) zeroCount++;
            }
            Set<Integer> set = new HashSet<>(list);
            if (!set.contains(0)) {
                System.out.println(1);
                System.out.println(1);
                System.out.println(n);
            } else if (zeroCount == n) {
                System.out.println(3);
                System.out.println(1);
                System.out.println(2);
                System.out.println(2);
                System.out.println(n - 1);
                System.out.println(1);
                System.out.println(2);
            } else {
                List<int[]> ops = new ArrayList<>();
                int last = -1;
                int st = -1;

                // Phase A: Handle blocks of two or more consecutive zeros
                for (int j = 0; j < list.size(); j++) {
                    int current = list.get(j);

                    if (last != current && current == 0) {
                        st = j + 1; // 1-based start index of the zero block
                    }

                    if (last == 0 && current != 0) {
                        // Condition: j is the 1-based index *after* the zero block.
                        // j - st is the count of zeros. We require > 1 (two or more).
                        if (j - st > 1) {
                            ops.add(new int[]{st, j}); // Store 1-based output indices

                            int st_0 = st - 1; // 0-based start index for list operations
                            list.subList(st_0, j).clear();
                            list.add(st_0, 1);

                            // Reset j to the index *before* the new insertion (st_0).
                            // The j++ step will then process the newly inserted '1' at st_0.
                            j = st_0 - 1;
                        }
                        st = -1;
                    }

                    last = current;
                }

                // Phase B: Handle remaining isolated zeros
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) == 0) {
                        if (j == 0) {
                            // Operation targets 0-based indices 0 and 1. Output is 1-based (1 and 2).
                            ops.add(new int[]{j + 1, j + 2});

                            int mex = 1;
                            if (list.get(j + 1) == 1) mex = 2;

                            list.subList(j, j + 2).clear();
                            list.add(j, mex);

                            // Reset j to -1 to ensure the next iteration starts at j=0
                            j = -1;
                        } else {
                            // Operation targets 0-based indices j-1 and j. Output is 1-based (j and j+1).
                            ops.add(new int[]{j, j + 1});

                            int mex = 1;
                            if (list.get(j - 1) == 1) mex = 2;

                            list.subList(j - 1, j + 1).clear();
                            list.add(j - 1, mex);

                            // Reset j two steps back. The j++ step will then process the
                            // newly inserted 'mex' value at index j-1.
                            j = j - 2;
                        }
                    }
                }

                System.out.println(ops.size());
                for (int[] op : ops) {
                    System.out.println(op[0]);
                    System.out.println(op[1]);
                }
            }
        }
    }
}