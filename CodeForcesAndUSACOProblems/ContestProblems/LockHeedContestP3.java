import java.util.*;
public class LockHeedContestP3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            String s = sc.nextLine();
            Set<Character> alpha = new HashSet<>();
            for (int j = 0; j < 26; j++) {
                alpha.add((char)('a' + j));
            }
            List<String> words = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if (alpha.contains(s.charAt(j)) || alpha.contains(Character.toLowerCase(s.charAt(j)))) sb.append(s.charAt(j));
                if (s.charAt(j) == '-' || s.charAt(j) == ' ') {
                    words.add(sb.toString());
                    sb.setLength(0);
                }
            }
            if (!sb.isEmpty()) words.add(sb.toString());
            StringBuilder res = new StringBuilder();
            for (String str : words) res.append(Character.toUpperCase(str.charAt(0)));
            System.out.println(res.toString());
        }
    }
}
