import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces2064C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Long> list = new ArrayList<>();
            for (int j = 0; j < n; j++) list.add(sc.nextLong());
            long totalScore = 0;
            long curpossum = 0;
            long curnegsum = 0;
            int latestPos = 0;
            int earliestNeg = 0;
            for (int j = 0; j < n; j++) {
                if (list.get(j) < 0) {
                    latestPos = j - 1;
                    break;
                }
                totalScore += list.get(j);
            }
            for (int j = n - 1; j >= 0; j--) {
                if (list.get(j) >= 0) {
                    earliestNeg = j + 1;
                    break;
                }
                totalScore += Math.abs(list.get(j));
            }
            if (earliestNeg - latestPos == 1) {
                System.out.println(totalScore);
            } else {
                List<Long> fixed = new ArrayList<>(list.subList(latestPos + 1, earliestNeg));
                //mark positives w worth it or not, take the furthest as the optimal.
                //same for negatives. then make sure they dont overlap and merge left to right for positive and right to left for negative.
                //worth it or not is at the position if curPossum >= curnegsum.
                int latestPosWorthIt = 0;
                long worthitpossum = 0;
                for (int j = 0; j < fixed.size(); j++) {
                    if (fixed.get(j) < 0) {
                        curnegsum += Math.abs(fixed.get(j));
                    } else {
                        curpossum += fixed.get(j);
                    }
                    if (fixed.get(j) >= 0 && curpossum >= curnegsum) {
                        latestPosWorthIt = j;
                        worthitpossum = curpossum;
                    }
                }
                long earliestnegworthitsum = 0;
                int earliestNegWorthIt = fixed.size() - 1;
                curnegsum = 0;
                curpossum = 0;
                for (int j = fixed.size() - 1; j >= 0; j--) {
                    if (fixed.get(j) >= 0) {
                        curpossum += fixed.get(j);
                    } else curnegsum += Math.abs(fixed.get(j));
                    if (fixed.get(j) < 0 && Math.abs(curnegsum) > curpossum) {
                        earliestNegWorthIt = j;
                        earliestnegworthitsum = curnegsum;
                    }
                }
                System.out.println(earliestnegworthitsum + worthitpossum);
            }
        }
    }
}
