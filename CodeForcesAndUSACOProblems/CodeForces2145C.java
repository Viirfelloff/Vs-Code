import java.util.*;

public class CodeForces2145C {
    //solution: turn string into -1 for b and 1 for a
    //remove the smallest substring so that the contribution == diff
    //use prefix values to get them
    //iterate through every possible r, check the latest l that satisfies the diff requirements
    //do above using dynamic hashmap
    //add to list of lengths
    //print ans
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            int aCount = 0;
            int bCount = 0;
            for (char c : s.toCharArray()) {
                if (c == 'a') aCount++;
                else bCount++;
            }
            int diff = aCount - bCount;
            if (diff == 0) System.out.println(0);
            else {
                List<Integer> pref = new ArrayList<>();
                int sum = 0;
                for (char c : s.toCharArray()) {
                    if (c == 'a') sum++;
                    else sum--;
                    pref.add(sum);
                }
                Map<Integer, Integer> lastSeen = new HashMap<>();
                lastSeen.put(0, -1);
                List<Integer> lengths = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    int desiredPrefVal = pref.get(j) - diff;
                    if (lastSeen.containsKey(desiredPrefVal)) {
                        int len = j - lastSeen.get(desiredPrefVal);
                        lengths.add(len);
                    }
                    lastSeen.put(pref.get(j), j);
                }
                int ans = Collections.min(lengths);
                if (ans == n) System.out.println(-1);
                else System.out.println(ans);
            }
        }
    }
}
