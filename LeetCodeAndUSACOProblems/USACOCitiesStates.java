package LeetCodeAndUSACOProblems;
import java.util.*;
//failed yet agian. youre never passing bronze at this pace.
public class USACOCitiesStates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        Map<String, String> citystate = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            String state = sc.next();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 2; j++) {
                sb.append(s.charAt(j));
            }
            if (citystate.containsKey(state) && citystate.get(state).contentEquals(sb)) {
                count++;
            }
            citystate.put(sb.toString(), state);
        }
        System.out.println(count);
    }
}
