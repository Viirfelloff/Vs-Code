import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces2176A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) list.add(sc.nextInt());
            int dec = 0;
            int last = list.get(0);
            boolean decr = false;
            int target = -1;
            for (int k = 0; k < n; k++) {
                if (last > list.get(k) && !decr) {
                    decr = true;
                    target = last;
                }
                if (decr && (target > list.get(k))) dec++;
                if (decr && (target <= list.get(k))) decr = false;
                last = list.get(k);
            }
            System.out.println(dec);
        }
    }
}
