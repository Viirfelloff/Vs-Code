import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//alr bro
public class CodeForces2181B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<Long> alice = new ArrayList<>();
            List<Long> bob = new ArrayList<>();
            for (int j = 0; j < n; j++) alice.add(sc.nextLong());
            for (int j = 0; j < m; j++) bob.add(sc.nextLong());
            Collections.sort(alice);
            Collections.sort(bob);
            boolean a = true;
            while (!alice.isEmpty() && !bob.isEmpty()) {
                long amax = alice.get(alice.size() - 1);
                long bmax = bob.get(bob.size() - 1);
                if (a) {
                    bob.remove(bob.size() - 1);
                    if (amax < bmax) {
                        bob = binarySearch(bob, bmax - amax);
                    }
                } else {
                    alice.remove(alice.size() - 1);
                    if (bmax < amax) {
                        alice = binarySearch(alice, amax - bmax);
                    }
                }
                a = !a;
            }
            System.out.println(alice.isEmpty() ? "Bob" : "Alice");
        }
    }
    public static List<Long> binarySearch(List<Long> list, long value){
        int l = 0;
        int r = list.size() - 1;
        while (l != r) {
            int mid = (l + r) / 2;
            if (value < list.get(mid)) r = mid;
            else if (value > list.get(mid)) l = mid;
        }
        return list;
    }
}
