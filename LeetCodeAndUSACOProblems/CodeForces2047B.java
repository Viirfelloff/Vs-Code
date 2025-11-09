import java.util.*;
public class CodeForces2047B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            if (s.length() == 1) {
                System.out.println(s);
            } else {
                // Count frequencies
                Map<Character, Integer> freq = new LinkedHashMap<>();
                for (char c : s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);

                // Find most and least frequent characters
                List<Character> chars = new ArrayList<>(freq.keySet());
                List<Integer> freqs = new ArrayList<>(freq.values());
                if (chars.size() == 1 && freqs.size() == 1) System.out.println(s);
                else {
                    char mostFreqChar = chars.get(freqs.indexOf(Collections.max(freqs)));
                    chars.remove(Character.valueOf(mostFreqChar));
                    freqs.remove(Integer.valueOf(freq.get(mostFreqChar)));
                    char leastFreqChar = chars.get(freqs.indexOf(Collections.min(freqs)));

                    // Convert string to list of characters
                    List<Character> list = new ArrayList<>();
                    for (char c : s.toCharArray()) list.add(c);

                    // Replace first occurrence of the **least frequent** char with the most frequent char
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j) == leastFreqChar) {
                            list.set(j, mostFreqChar);
                            break;
                        }
                    }

                    // Build and print new string
                    StringBuilder sb = new StringBuilder();
                    for (char c : list) sb.append(c);
                    System.out.println(sb.toString());
                }
            }
        }
    }
}
