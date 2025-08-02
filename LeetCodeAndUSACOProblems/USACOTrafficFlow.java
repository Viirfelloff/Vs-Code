package LeetCodeAndUSACOProblems;
import java.util.*;

public class USACOTrafficFlow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<String> types = new ArrayList<>();
        List<int[]> ranges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            types.add(sc.next());
            int lo = sc.nextInt();
            int hi = sc.nextInt();
            ranges.add(new int[]{lo, hi});
        }

        // Step 1: Merge consecutive "none"
        for (int i = 1; i < types.size(); ) {
            if (types.get(i).equals("none") && types.get(i - 1).equals("none")) {
                int[] a = ranges.get(i - 1), b = ranges.get(i);
                int newLow = Math.max(a[0], b[0]);
                int newHigh = Math.min(a[1], b[1]);
                ranges.set(i, new int[]{newLow, newHigh});
                types.remove(i - 1);
                ranges.remove(i - 1);
                i = Math.max(1, i - 1);
            } else {
                i++;
            }
        }

        // Step 2: Find the index of the "none" segment
        int noneIndex = -1;
        for (int i = 0; i < types.size(); i++) {
            if (types.get(i).equals("none")) {
                noneIndex = i;
                break;
            }
        }

        // Defensive copy of ranges for before and after
        int[] before = new int[]{ranges.get(noneIndex)[0], ranges.get(noneIndex)[1]};
        int[] after = new int[]{ranges.get(noneIndex)[0], ranges.get(noneIndex)[1]};

        // Step 3: Go backward to find flow before mile 1
        for (int i = noneIndex - 1; i >= 0; i--) {
            String type = types.get(i);
            int lo = ranges.get(i)[0], hi = ranges.get(i)[1];
            if (type.equals("on")) {
                // On-ramps add traffic: going backward, subtract traffic added
                before[0] = Math.max(0, before[0] - hi);
                before[1] = Math.max(0, before[1] - lo);
            } else if (type.equals("off")) {
                // Off-ramps remove traffic: going backward, add traffic removed
                before[0] += lo;
                before[1] += hi;
            }
        }

        // Step 4: Go forward to find flow after mile N
        for (int i = noneIndex + 1; i < types.size(); i++) {
            String type = types.get(i);
            int lo = ranges.get(i)[0], hi = ranges.get(i)[1];
            if (type.equals("on")) {
                // On-ramps add traffic going forward
                after[0] += lo;
                after[1] += hi;
            } else if (type.equals("off")) {
                // Off-ramps remove traffic going forward
                after[0] = Math.max(0, after[0] - hi);
                after[1] = Math.max(0, after[1] - lo);
            }
        }

        // Output the result
        System.out.println(before[0] + " " + before[1]);
        System.out.println(after[0] + " " + after[1]);
    }
}
