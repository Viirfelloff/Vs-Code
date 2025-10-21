import java.util.*;

public class USACOLeaders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int[] e = new int[n + 1];
        for (int i = 1; i <= n; i++) e[i] = sc.nextInt();

        int totalG = 0, totalH = 0;
        for (char c : s.toCharArray()) {
            if (c == 'G') totalG++;
            else totalH++;
        }

        int[] prefixG = new int[n + 1];
        int[] prefixH = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixG[i] = prefixG[i - 1] + (s.charAt(i - 1) == 'G' ? 1 : 0);
            prefixH[i] = prefixH[i - 1] + (s.charAt(i - 1) == 'H' ? 1 : 0);
        }

        Set<Integer> firstLeaders = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == 'G') {
                int gInRange = prefixG[e[i]] - prefixG[i - 1];
                if (gInRange == totalG) firstLeaders.add(i);
            } else {
                int hInRange = prefixH[e[i]] - prefixH[i - 1];
                if (hInRange == totalH) firstLeaders.add(i);
            }
        }

        int minG = Integer.MAX_VALUE, maxG = -1;
        int minH = Integer.MAX_VALUE, maxH = -1;
        for (int idx : firstLeaders) {
            if (s.charAt(idx - 1) == 'G') {
                minG = Math.min(minG, idx);
                maxG = Math.max(maxG, idx);
            } else {
                minH = Math.min(minH, idx);
                maxH = Math.max(maxH, idx);
            }
        }

        Set<Integer> gLeaders = new HashSet<>();
        Set<Integer> hLeaders = new HashSet<>();

        // second condition
        for (int i = 1; i <= n; i++) {
            int right = e[i];
            char breed = s.charAt(i - 1);
            if (breed == 'G') {
                if ((right >= minH && i <= maxH) || firstLeaders.contains(i)) {
                    gLeaders.add(i);
                }
            } else {
                if ((right >= minG && i <= maxG) || firstLeaders.contains(i)) {
                    hLeaders.add(i);
                }
            }
        }

        System.out.println(gLeaders.size() * hLeaders.size());
    }
}