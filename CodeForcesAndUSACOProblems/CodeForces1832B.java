import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeForces1832B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            List<Long> nums = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                nums.add(sc.nextLong());
            }
            List<Long> copy = new ArrayList<>(nums);
            Collections.sort(copy);
            for (int j = 0; j < k; j++) {
                //get 2 mins
                long min1 = copy.get(0);
                long min2 = copy.get(1);
                if (min1 + min2 > copy.get(copy.size() - 1)) {
                    copy.remove(copy.size() - 1);
                } else {
                    copy.remove(0);
                    copy.remove(0);
                }
            }
            long sum = 0;
            for (long x : copy) sum += x;
            System.out.println(sum);
        }
    }
}
