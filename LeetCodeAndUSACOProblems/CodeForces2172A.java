import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeForces2172A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        int c = sc.nextInt();
        int l = sc.nextInt();
        List<Integer> list = Arrays.asList(g,c,l);
        if (Collections.max(list) - Collections.min(list) >= 10) System.out.println("check again");
        else {
            Collections.sort(list);
            System.out.println("final" + " " + list.get(1));
        }
    }
}
