import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeForces2176B {
    public static List<Integer> getZeroDistances(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        List<Integer> zeroDistances = new ArrayList<>();

        // Check if there's at least one '1'
        boolean hasOne = false;
        for (char c : arr) if (c == '1') hasOne = true;
        if (!hasOne) return zeroDistances; // no '1' to measure distance

        // Find last '1' index (for circular wrap-around)
        int lastOne = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == '1') {
                lastOne = i;
                break;
            }
        }

        // Walk through array and calculate distances
        int prevOne = lastOne;
        for (int i = 0; i < n; i++) {
            if (arr[i] == '1') {
                prevOne = i;
            } else {
                int dist = (i - prevOne + n) % n;
                zeroDistances.add(dist);
            }
        }

        return zeroDistances;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            List<Integer> shifts = getZeroDistances(s);
            int toSubtract = 0;
            Collections.sort(shifts);
            int res = 0;
            for (int x : shifts) {
                int newX = x - toSubtract;
                res += newX;
                toSubtract += newX;
            }
            System.out.println(res);
        }
    }
}
