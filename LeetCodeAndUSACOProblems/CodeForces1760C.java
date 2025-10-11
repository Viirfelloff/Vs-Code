import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeForces1760C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(sc.nextInt());
            }
            List<Integer> copy = new ArrayList<>(list);
            Collections.sort(copy);
            int max = copy.get(copy.size() - 1);
            int max2 = copy.get(copy.size() - 2);
            for (int x : list) {
                if (x == max) {
                    System.out.println(x - max2);
                } else {
                    System.out.println(x - max);
                }
            }
        }
    }
}
