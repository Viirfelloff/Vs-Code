import java.util.Scanner;

public class CodeForcesDiv4Contest2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int h = sc.nextInt();
            int[] arr = new int[n];
            int[] original = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
                original[j] = arr[j];
            }
            for (int j = 0; j < m; j++) {
                int idx = sc.nextInt() - 1;
                int change = sc.nextInt();
                arr[idx] += change;
                if (arr[idx] > h) {
                    System.arraycopy(original, 0, arr, 0, n);
                }
            }
            for (int j = 0; j < n; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }
}
