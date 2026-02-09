import java.util.Optional;
import java.util.Scanner;

public class CALICOP2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String s = sc.next();
            String s2 = sc.next();
            boolean string1 = false;
            boolean string2 = false;
            if ((s.equals("fuzz") || s.equals("bizz") || s.equals("bizzfuzz"))) {
                string1 = true;
            }
            if (s2.equals("fuzz") || s2.equals("bizz") || s2.equals("bizzfuzz")) {
                string2 = true;
            }
            if (string1 && string2) System.out.println("crap");
            else {
                if (!string1) {
                    int res = Integer.parseInt(s) + 2;
                    if (res % 5 == 0 && res % 3 == 0) {
                        System.out.println("bizzfuzz");
                    }
                    else if (res % 3 == 0) {
                        System.out.println("bizz");
                    }
                    else if (res % 5 == 0) {
                        System.out.println("fuzz");
                    } else {
                        System.out.println(res);
                    }
                }
                else {
                    int res = Integer.parseInt(s2) + 1;
                    if (res % 5 == 0 && res % 3 == 0) {
                        System.out.println("bizzfuzz");
                    }
                    else if (res % 3 == 0) {
                        System.out.println("bizz");
                    }
                    else if (res % 5 == 0) {
                        System.out.println("fuzz");
                    } else {
                        System.out.println(res);
                    }
                }
            }
        }
    }
}
