import java.util.Scanner;
public class LockHeedContestP1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            int allowed = Integer.parseInt(sc.nextLine());
            String[] tim = sc.nextLine().split(" ");
            int sum = Integer.parseInt(tim[0]) + Integer.parseInt(tim[1]);
            System.out.println(sum <= allowed ? "PASS" : sum - allowed);
        }
    }
}
