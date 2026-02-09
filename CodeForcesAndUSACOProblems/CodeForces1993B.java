import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeForces1993B {
    //why are we bipolar with 1200s and 1100s
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Long> odds = new ArrayList<>();
            List<Long> evens = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                long x = sc.nextLong();
                if (x % 2 == 0) evens.add(x);
                else odds.add(x);
            }
            Collections.sort(evens);
            if (odds.isEmpty() || evens.isEmpty()) System.out.println(0);
            else {
                long biggestOdd = Collections.max(odds);
                int moves = 0;
                for (long y : evens) {
                    if (y < biggestOdd) {
                        moves++;
                        biggestOdd = y + biggestOdd;
                    } else {
                        moves += 2;
                        //simulate twice
                        //odd becomes odd + even, and then do it again
                        biggestOdd = y + biggestOdd;
                        biggestOdd = y + biggestOdd;
                    }
                }
                System.out.println(moves);
            }
        }
    }
}