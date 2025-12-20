import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces2128C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Long> list = new ArrayList<>();
            for (int j = 0; j < n; j++) list.add(sc.nextLong());
            //it matters where the increase is.
            //assume that if there is more than one increase, it is impossible.
            //upper bound = current min
            //if its continuous decreasing, this bound does not matter.
            //it only applies to increases
            //every time you add to the current number, the local bound changes.
            //this provides the minimum added so that you can continue increasing.
            //pick greedily between these two bounds.
            //for every element local bound starts at 1
            //remember global upper bound is inclusive
            //for each element take the target and the bounds (one is updating)
            //make the operations
            //remember lower bound is also inclusive
            /// test for getting more testcases bro i give up
            int dec = 0;
            long last = list.get(0);
            for (int k = 1; k < n; k++) {
                if (k != n - 1) {
                    if (last < list.get(k)) dec++;
                } else {
                    if (last < list.get(k)) dec = 10;
                }
                last = list.get(k);
            }
            if (dec == 0 || dec == 1) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
