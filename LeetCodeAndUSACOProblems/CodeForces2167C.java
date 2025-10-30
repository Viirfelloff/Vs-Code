import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeForces2167C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> nums = new ArrayList<>();
            int evens = 0;
            int odds = 0;
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                if (x % 2 == 0) evens++;
                else odds++;
                nums.add(x);
            }
            if (evens == 0 && odds != 0 || evens != 0 && odds == 0) {
                for (int x : nums) System.out.println(x);
            } else {
                Collections.sort(nums);
                for (int y : nums) System.out.println(y);
            }
        }
    }
}
