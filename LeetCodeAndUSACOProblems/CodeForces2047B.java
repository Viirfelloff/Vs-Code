import java.util.*;
public class CodeForces2047B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            Map<Character, Integer> freq = new HashMap<>();
            for (char c : s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);

// 2. Find character with max frequency
            char c_max = s.charAt(0);
            int maxFreq = 0;
            for (Map.Entry<Character, Integer> e : freq.entrySet()) {
                if (e.getValue() > maxFreq) {
                    maxFreq = e.getValue();
                    c_max = e.getKey();
                }
            }

// 3. Replace first char not equal to c_max
            char[] arr = s.toCharArray();
            for (int ii = 0; ii < arr.length; ii++) {
                if (arr[ii] != c_max) {
                    arr[ii] = c_max;
                    break;
                }
            }

            System.out.println(new String(arr));
        }
    }
}
