
import java.util.Scanner;

public class USACOContest2P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            StringBuilder ans = new StringBuilder();
            boolean flipped = false;
            for (int j = s.length() - 1; j >= 0; j--) {
                char c = s.charAt(j);
                if (flipped) {
                    //flip char
                    if (c == 'M') ans.append('O');
                    else ans.append('M');
                } else {
                    ans.append(c);
                }
                if (ans.charAt(ans.length() - 1) == 'O') flipped = !flipped;
            }
            //thres no way i just got hits in 15 mins
            System.out.println("YES");
            if (k == 1) {
                System.out.println(ans.reverse());
            }
        }
    }
}
