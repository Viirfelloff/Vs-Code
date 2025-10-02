import java.util.*;

public class CodeForces1927B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] trace = new int[n];
            for (int i = 0; i < n; i++) trace[i] = sc.nextInt();

            List<Character> built = new ArrayList<>();
            Map<Character, Integer> counts = new HashMap<>();
            char nextChar = 'a';

            for (int i = 0; i < n; i++) {
                if (trace[i] == 0) {
                    // new letter
                    built.add(nextChar);
                    counts.put(nextChar, 1);
                    nextChar++;
                    if (nextChar > 'z') nextChar = 'a'; // wrap if needed
                } else {
                    // find the earliest letter with count == trace[i]
                    for (char c : built) {
                        int cnt = counts.get(c);
                        if (cnt == trace[i]) {
                            built.add(c);
                            counts.put(c, cnt + 1);
                            break;
                        }
                    }
                }
            }

            // convert to string and print
            StringBuilder sb = new StringBuilder();
            for (char c : built) sb.append(c);
            System.out.println(sb);
        }
        sc.close();
    }
}
