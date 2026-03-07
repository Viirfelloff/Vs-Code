import java.util.Scanner;
public class CodeForces2010C1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mixed = sc.next();
        String res = " ";
        int n = mixed.length();
        if (n == 1) System.out.println("NO");
        else {
            if (n % 2 == 0) {
                int idx1 = mixed.length() / 2 - 1;
                int idx2 = mixed.length() / 2;
                while (idx1 > 0 && idx2 < n) {
                    String overlap = mixed.substring(idx1, idx2 + 1);
                    String s1 = mixed.substring(0, idx1) + overlap;
                    String s2 = overlap + mixed.substring(idx2 + 1);
                    if (s1.equals(s2)) {
                        res = s1;
                        break;
                    }
                    idx1--;
                    idx2++;
                }
            } else {
                int idx = mixed.length() / 2;
                String overlap = mixed.substring(idx, idx + 1);
                if ((mixed.substring(0, idx) + overlap).equals(overlap + mixed.substring(idx + 1))) {
                    res = mixed.substring(0, idx) + overlap;
                } else {
                    int idx1 = idx - 1;
                    int idx2 = idx + 1;
                    while (idx1 > 0 && idx2 < n) {
                        String overlap2 = mixed.substring(idx1, idx2 + 1);
                        String s1 = mixed.substring(0, idx1) + overlap2;
                        String s2 = overlap2 + mixed.substring(idx2 + 1);
                        if (s1.equals(s2)) {
                            res = s1;
                            break;
                        }
                        idx1--;
                        idx2++;
                    }
                }
            }
            if (res.equals(" ")) System.out.println("NO");
            else {
                System.out.println("YES");
                System.out.println(res);
            }
        }
    }
}
