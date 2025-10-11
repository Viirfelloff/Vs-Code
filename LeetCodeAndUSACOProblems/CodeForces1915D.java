

import java.util.*;

public class CodeForces1915D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e'));
            StringBuilder ans = new StringBuilder();

            int i = 0;
            while (i < n) {
                // Every syllable starts with a consonant (C)
                ans.append(s.charAt(i)); // add C
                i++;

                if (i < n && vowels.contains(s.charAt(i))) {
                    // add vowel
                    ans.append(s.charAt(i));
                    i++;

                    // check next pattern
                    if (i < n) {
                        // if next next char pattern is "CV", then split after CV
                        if (i + 1 < n && !vowels.contains(s.charAt(i)) && vowels.contains(s.charAt(i + 1))) {
                            ans.append('.');
                        }
                        // else pattern looks like "CVC", so include next consonant then split
                        else if (i < n && !vowels.contains(s.charAt(i))) {
                            ans.append(s.charAt(i));
                            i++;
                            if (i < n) ans.append('.');
                        }
                    }
                }
            }

            System.out.println(ans.toString());
        }
        sc.close();
    }
}
