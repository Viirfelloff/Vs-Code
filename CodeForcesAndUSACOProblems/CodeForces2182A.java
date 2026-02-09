import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces2182A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            //test occurrences of 2026 ? true ==> 0
            //2025 ? true ==> 1
            //202 ? true ==> 1
            //20 ? true ==> 2
            //2 ? true ==> 3
            //else 4
            int ops = -1;
            if (!getOccurrences(s, "2026").isEmpty()) {
                ops = getOccurrences(s, "2025").size();
            }
            else if (!getOccurrences(s, "2025").isEmpty()) {
                List<Integer> idxes = getOccurrences(s, "2025");
                ops = idxes.size();
            }
            else if (!getOccurrences(s, "202").isEmpty() && !checkEnd(s, "202", getOccurrences(s, "202"))) {
                ops = 1;
            }
            else if (!getOccurrences(s, "20").isEmpty() && !checkEnd(s, "20", getOccurrences(s, "20"))) {
                ops = 2;
            }
            else if (!getOccurrences(s, "2").isEmpty() && !checkEnd(s, "2", getOccurrences(s, "2"))) {
                ops = 3;
            } else {
                ops = 4;
            }
            System.out.println(ops);
        }
    }
    public static List<Integer> getOccurrences(String s, String target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i + target.length() <= s.length(); i++) {
            if (s.substring(i, i + target.length()).equals(target)) {
                list.add(i);
            }
        }
        return list;
    }
    public static boolean checkEnd(String s, String target, List<Integer> idx) {
        if (s.length() - 1 - (idx.get(idx.size() - 1) + target.length() - 1) >= 4 - target.length()) return false;
        return true;
    }
}
