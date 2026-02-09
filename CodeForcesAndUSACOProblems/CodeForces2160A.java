import java.util.*;
public class CodeForces2160A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0;i < t; i++) {
            int n = sc.nextInt();
            List<Integer> set = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                set.add(sc.nextInt());
            }
            int mex = 0;
            for (int k = 0; k < n; k++) {
                if (!set.contains(k)) {
                    mex = k;
                    break;
                }
            }
            System.out.println(mex);
        }
    }
}
