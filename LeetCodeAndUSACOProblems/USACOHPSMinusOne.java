import java.util.*;
//les fucking go
public class USACOHPSMinusOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Character>> chart = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String line = sc.next(); // or sc.nextLine().trim() if spaces exist
            List<Character> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                cur.add(line.charAt(j));
            }
            chart.add(cur);
        }
        List<Integer> res = new ArrayList<>();
        for (int k = 0; k < m; k++) {
            int bessieleft = sc.nextInt();
            int bessieright = sc.nextInt();
            Set<Integer> both = new HashSet<>();
            if (bessieleft == bessieright) {
                for (int symbol = 1; symbol <= n; symbol++) {
                    if (symbol >= bessieleft) {
                        char cond = chart.get(symbol - 1).get(bessieleft - 1);
                        if (cond == 'W') both.add(symbol);
                    } else {
                        char cond = chart.get(bessieleft - 1).get(symbol - 1);
                        if (cond == 'L') both.add(symbol);
                    }
                }
            } else {
                for (int symbol = 1; symbol <= n; symbol++) {
                    boolean left = false;
                    boolean right = false;
                    if (symbol >= bessieleft) {
                        char cond = chart.get(symbol - 1).get(bessieleft - 1);
                        if (cond == 'W') left = true;
                    } else {
                        char cond = chart.get(bessieleft - 1).get(symbol - 1);
                        if (cond == 'L') left = true;
                    }
                    if (symbol >= bessieright) {
                        char cond = chart.get(symbol - 1).get(bessieright - 1);
                        if (cond == 'W') right = true;
                    } else {
                        char cond = chart.get(bessieright - 1).get(symbol - 1);
                        if (cond == 'L') right = true;
                    }
                    if (left && right) both.add(symbol);
                }
            }
            int combinations = 0;
            for (int l = 1; l <= both.size(); l++) {
                combinations++;
                combinations += 2 * (n - l);
            }
            res.add(combinations);
        }
        for (int x : res) System.out.println(x);
    }
}
