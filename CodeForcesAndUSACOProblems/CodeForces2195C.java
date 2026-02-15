import java.util.*;
public class CodeForces2195C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> sequence = new ArrayList<>();
            for (int j = 0; j < n; j++) sequence.add(sc.nextInt());
            Set<Integer> changedidx = new HashSet<>();
            int moves = 0;
            for (int j = 0; j < n - 1; j++) {
                if (sequence.get(j + 1) == 7 - sequence.get(j) && !changedidx.contains(j) && !changedidx.contains(j + 1)) {
                    moves++;
                    changedidx.add(j);
                    changedidx.add(j + 1);
                }
            }
            System.out.println(moves);
        }
    }
}
