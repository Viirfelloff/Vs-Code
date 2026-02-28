import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CodeForces1989C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> m1 = new ArrayList<>();
            List<Integer> m2 = new ArrayList<>();
            for (int j = 0; j < n; j++) m1.add(sc.nextInt());
            for (int j = 0; j < n; j++) m2.add(sc.nextInt());
            List<Integer> undecided = new ArrayList<>();
            int rating1 = 0;
            int rating2 = 0;
            for (int j = 0; j < n; j++) {
                int movieone = m1.get(j);
                int movietwo = m2.get(j);
                if (movietwo == movieone && (movietwo == -1 || movietwo == 1)) undecided.add(j);
                else {
                    if (movieone > movietwo) rating1 += movieone;
                    else rating2 += movietwo;
                }
            }
            for (int j = 0; j < undecided.size(); j++) {
                int movieone = m1.get(undecided.get(j));
                int movietwo = m2.get(undecided.get(j));
                if (movieone == movietwo && movieone == -1) {
                    if (rating1 < rating2) rating2--;
                    else rating1--;
                } else if (movieone == movietwo && movieone == 1) {
                    if (rating1 < rating2) rating1++;
                    else rating2++;
                }
            }
            System.out.println(Math.min(rating1, rating2));
        }
    }
}
