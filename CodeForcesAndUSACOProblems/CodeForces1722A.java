
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CodeForces1722A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            char[] name = {'T','i','m','u','r'};
            Arrays.sort(name);

            char[] sArr = s.toCharArray();
            Arrays.sort(sArr);

            if (Arrays.equals(name, sArr)) System.out.println("YES");
            else System.out.println("NO");

        }
    }
}
