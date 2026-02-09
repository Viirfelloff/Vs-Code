package CodeForcesAndUSACOProblems;
//strat: check each given boundary and see how many cows are lying for that given boundary
// take min of all lying cows for each check.
import java.util.*;
//les go we got it
public class USACOLying {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> tests = new ArrayList<>();
        List<String> range = new ArrayList<>();
        for (int i = 0; i< n; i++) {
            range.add(sc.next());
            tests.add(sc.nextInt());
        }
        List<Integer> lies = new ArrayList<>();
        for (int j = 0; j < tests.size(); j++) {
            int lie = 0;
            int check = tests.get(j);
            for (int m = 0; m < n; m++) {
                String s = range.get(m);
                int b = tests.get(m);
                if (s.equals("G")) {
                    if (check < b) lie++;
                } else {
                    if (check > b) lie++;
                }
            }
            lies.add(lie);
        }
        System.out.println(Collections.min(lies));
    }
}
