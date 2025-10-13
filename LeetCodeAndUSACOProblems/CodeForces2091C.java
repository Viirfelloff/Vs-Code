import java.util.Scanner;
public class CodeForces2091C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            if (n % 2 == 0) System.out.println(-1);
            else {
                //build permutation
                int[] res = new int[n];
                res[0] = 1;
                int currentValue = 2;
                for (int j = 1; j < n; j++) {
                    //moves = j
                    res[j] = (currentValue + j) % n;
                    currentValue++;
                }
                for (int x : res) {
                    if (x == 0) System.out.println(n);
                    else System.out.println(x);
                }
            }
        }
    }
}
