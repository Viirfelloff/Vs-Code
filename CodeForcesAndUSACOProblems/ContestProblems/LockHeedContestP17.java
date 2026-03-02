import java.util.*;
public class LockHeedContestP17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            String s = sc.nextLine();
            int wordc = s.split(" ").length;
            int cc = s.length();
            Map<Character, Integer> freq = new HashMap<>();
            for (char c : s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);
            Set<Integer> freqs = new HashSet<>(freq.values());
            List<Integer> listfreq = new ArrayList<>(freqs);
            Collections.sort(listfreq, Collections.reverseOrder());
            System.out.println(s);
            System.out.println("-".repeat(s.length()));
            System.out.println("CHARACTERS: " + cc);
            System.out.println("WORDS: " + wordc);
            for (int f : listfreq) {
                Set<Character> alrout = new HashSet<>();
                for (char c : s.toCharArray()) {
                    if (freq.get(c) == f && !alrout.contains(c)) {
                        System.out.println(c + ": " + f);
                        alrout.add(c);
                    }
                }
            }
        }
    }
}