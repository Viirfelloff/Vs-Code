import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.StreamSupport;

public class CodeForcesCodingClubA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> graph = new ArrayList<>();
        for (int j = 0; j < n; j++) graph.add(sc.nextInt() - 1);
        boolean valid = false;
        for (int x : graph) {
            //1 indexed
            int likes = graph.get(x);
            int likes2 = graph.get(likes);
            if (graph.get(likes2) == x) {
                valid = true;
            }
        }
        if (valid) System.out.println("YES");
        else System.out.println("NO");
    }
}
