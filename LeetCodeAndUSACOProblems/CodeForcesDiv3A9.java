
import java.util.*;

public class CodeForcesDiv3A9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i =0;i <t;i++) {
            Set<Integer> ys = new HashSet<>();
            Set<Integer> xs = new HashSet<>();
            for (int j = 0; j < 4; j++) {
                xs.add(sc.nextInt());
                ys.add(sc.nextInt());
            }
            List<Integer> x = new ArrayList<>(xs);
            List<Integer> y = new ArrayList<>(ys);
            System.out.println(Math.abs(x.get(0) - x.get(1)) * Math.abs(y.get(0) - y.get(1)));
        }
    }
}
