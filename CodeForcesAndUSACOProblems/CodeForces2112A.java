
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class CodeForces2112A {
    public static String solution (int a, int x, int y) {
        int sols = 0;
        Set<Integer> possibledists = new HashSet<>();
        int dist1 = Math.abs(a - x);
        int dist2 = Math.abs(a - y);
        int target = Math.min(dist1, dist2);
        for (int i = 0; i < target; i++) {
            possibledists.add(i);
        }
        Set<Integer> possiblesols = new HashSet<>();
        for (int l : possibledists) {
            possiblesols.add(x + l);
            possiblesols.add(x - l);
            possiblesols.add(y + l);
            possiblesols.add(y - l);
        }
        for (int g : possiblesols) {
            if (Math.abs(g - x) < dist1 && Math.abs(g - y) < dist2) {
                sols++;
            }
        }
        if (sols >= 1) {
            return "YES";
        }
        return "NO";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println(solution(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
    }
}
