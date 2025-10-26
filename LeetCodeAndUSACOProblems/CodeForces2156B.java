import java.util.Scanner;

public class CodeForces2156B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            String typerocks = sc.next();
            for (int j = 0; j < q; j++) {
                int num = sc.nextInt();
                int seconds = 0;
                int machineNumber = 0;
                while (num != 0) {
                    if (typerocks.charAt(machineNumber) == 'A') {
                        num--;
                    } else {
                        num /= 2;
                    }
                    if (machineNumber == n - 1) {
                        machineNumber = 0;
                    } else {
                        machineNumber++;
                    }
                    seconds++;
                }
                System.out.println(seconds);
            }
        }
    }
}
