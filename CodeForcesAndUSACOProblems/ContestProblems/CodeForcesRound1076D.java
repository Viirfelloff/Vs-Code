import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeForcesRound1076D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Long> swords = new ArrayList<>();
            List<Integer> bosses = new ArrayList<>();
            List<Long> possibleScores = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                long x = sc.nextLong();
                swords.add(x);
            }
            for (int j = 0; j < n; j++) {
                bosses.add(sc.nextInt());
            }
            Collections.sort(swords);
            //idea = take all swords, subtract 1 each iteration
            //for each, x = min current sequence.
            //multiply by levels able to be beaten by current # of swords
            //take max of possible scores at the end.
            Collections.sort(bosses, Collections.reverseOrder());
            long[] prefix = new long[n];
            prefix[0] = bosses.get(0);
            for (int k = 1; k < n; k++) {
                prefix[k] = prefix[k - 1] + bosses.get(k);
            }
            int j = 0;
            for (int m = n; m > 0; m--) {
                long x = swords.get(j);
                //swords left = m;
                //yay binary search time
                //essentially finds the insertion position where we can beat the boss
                //avoids tle with traditional sequential search.
                int left = 0;
                int right = n - 1;
                int beaten = 0;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (prefix[mid] <= m) {
                        beaten = mid + 1;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                possibleScores.add(x * beaten);
                j++;
            }
            System.out.println(Collections.max(possibleScores));
        }
    }
}
