import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CALICOP1 {

    static class Announcement {
        int index;
        double probability;
        int reacts; // Number of REACTs to send

        public Announcement(int index, double probability) {
            this.index = index;
            this.probability = probability;
            this.reacts = 0;
        }
    }

    // Function to calculate the probability of an odd number of successes
    public static double probabilityOdd(int k, double P) {
        if (k == 0) return 0.0;
        return (1.0 - Math.pow(1.0 - 2.0 * P, k)) / 2.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int A = scanner.nextInt();

        // The minimum number of successful reactions required: ceil(0.60 * A)
        int targetSuccessCount = (int) Math.ceil(0.60 * A);
        final int MAX_REACTS = 499; // Max moves per announcement is 500 (499 REACT + 1 NEXT)

        List<Announcement> announcements = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            if (scanner.hasNextDouble()) {
                double P = scanner.nextDouble();
                announcements.add(new Announcement(i, P));
            } else {
                break;
            }
        }
        scanner.close();

        // 1. Sort by probability in descending order.
        announcements.sort(Comparator.comparingDouble((Announcement a) -> a.probability).reversed());

        // 2. Allocate moves for the target group (top 60%).
        for (int i = 0; i < targetSuccessCount && i < A; i++) {
            Announcement ann = announcements.get(i);

            // Set a guaranteed target probability for success (e.g., 99.99%)
            final double CERTAINTY_THRESHOLD = 0.9999;

            // If probability is already high, 1 REACT is best.
            if (ann.probability > 0.5) {
                ann.reacts = 1;
            } else {
                // For low P_i, we need multiple REACTs.
                // We find the smallest ODD k that meets the certainty threshold.
                // Since the move budget is ample, a simple heuristic is to use
                // the full budget for the low-P announcements in the target group.

                // If the lowest P (0.005) needs k approx 460 for 99% certainty,
                // setting k=499 is the safest bet for all low P in the target group.
                ann.reacts = MAX_REACTS;

                // Optimization: if even 1 REACT is enough for the certainty target
                // for some moderate P_i, use k=1.
                if (probabilityOdd(1, ann.probability) >= CERTAINTY_THRESHOLD) {
                    ann.reacts = 1;
                }
            }
        }

        // 3. Output REACT/NEXT sequence in the original order.
        // We use a final map based on the original index for output
        int[] finalReacts = new int[A];
        for (Announcement ann : announcements) {
            finalReacts[ann.index] = ann.reacts;
        }

        for (int i = 0; i < A; i++) {
            for (int j = 0; j < finalReacts[i]; j++) {
                System.out.println("REACT");
            }
            System.out.println("NEXT");
        }
    }
}