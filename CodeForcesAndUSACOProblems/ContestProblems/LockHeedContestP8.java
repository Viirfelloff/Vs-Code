import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class LockHeedContestP8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            int a = Integer.parseInt(sc.nextLine());
            List<Integer> list = new ArrayList<>();
            while (a != 0) {
                int val = (int) Math.sqrt((double)a);
                list.add(val * val);
                a -= (val * val);
            }
            int[] res = new int[list.size()];
            for (int j = 0; j < list.size(); j++) res[j] = list.get(j);
            System.out.println(Arrays.toString(res));
        }
    }
}
