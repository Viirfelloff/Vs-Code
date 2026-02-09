import java.util.*;

public class CodeForces1722D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int j = 0; j < t; j++) {
            int n = sc.nextInt();
            String s = sc.next();
            long count = 0;
            List<Long> gain = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'L') {
                    count += i;
                    gain.add((long)(n - 1 - 2*i)); // gain if flipped
                } else {
                    count += n - 1 - i;
                    gain.add((long)(2*i - (n - 1))); // gain if flipped
                }
            }

            gain.sort((a,b) -> Long.compare(b,a));

            long current = count;
            for (int m = 0; m < n; m++) {
                if (gain.get(m) > 0) current += gain.get(m);
                System.out.print(current + " ");
            }
            System.out.println();
        }
    }
}
