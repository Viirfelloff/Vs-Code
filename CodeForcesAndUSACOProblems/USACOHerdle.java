package CodeForcesAndUSACOProblems;
import java.util.*;
//lowk too much help but we still got it mostly
public class USACOHerdle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> grid = new ArrayList<>();
        ArrayList<String> guesses = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            if (i < 3) grid.add(sc.next());
            else guesses.add(sc.next());
        }

        int greens = 0;
        Map<Character, Integer> freq1 = new HashMap<>();
        Map<Character, Integer> freq2 = new HashMap<>();

        // Step 1: Count greens and build frequency maps ignoring greens
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                char g = grid.get(r).charAt(c);
                char u = guesses.get(r).charAt(c);

                if (g == u) {
                    greens++;
                } else {
                    freq1.put(g, freq1.getOrDefault(g, 0) + 1);
                    freq2.put(u, freq2.getOrDefault(u, 0) + 1);
                }
            }
        }

        // Step 2: Count yellows by min of overlapping chars
        int yellows = 0;
        for (char ch : freq1.keySet()) {
            if (freq2.containsKey(ch)) {
                yellows += Math.min(freq1.get(ch), freq2.get(ch));
            }
        }

        System.out.println(greens);
        System.out.println(yellows);
    }
}
