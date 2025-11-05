import java.util.*;

public class CodeForces2060A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int[] arr = new int[5];
            for (int k = 0; k < 5; k++) {
                if (k != 2) {
                    arr[k] = sc.nextInt();
                }
            }
            Map<Integer, Integer> freqs = new HashMap<>();
            freqs.put(arr[0] + arr[1], freqs.getOrDefault(arr[0] + arr[1],0) + 1);
            freqs.put(arr[3] - arr[1], freqs.getOrDefault(arr[3] - arr[1], 0) + 1);
            freqs.put(arr[4] - arr[3], freqs.getOrDefault(arr[4] - arr[3], 0) + 1);
            System.out.println(Collections.max(freqs.values()));
        }
    }
}
