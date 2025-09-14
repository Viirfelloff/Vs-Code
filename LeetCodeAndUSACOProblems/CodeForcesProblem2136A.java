package LeetCodeAndUSACOProblems;
import java.util.Scanner;

public class CodeForcesProblem2136A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            int onecount = 0;
            for (int j = 0; j < n; j++) {
                boolean[] arr = new boolean[n];
                int inc = 0;
                for (char c : s.toCharArray()) {
                    if (c == '0') {
                        arr[inc] = false;
                    } else {
                        arr[inc] = true;
                    }
                    inc++;
                }
                arr[j] = !arr[j];
                for (boolean tt : arr) {
                    if (tt) onecount++;
                }
            }
            System.out.println(onecount);
        }
    }
}
