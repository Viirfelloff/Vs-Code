package LeetCodeAndUSACOProblems;
import java.util.*;
//we failed yet again
public class USACOCitiesStates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            String city = sc.next();
            String state = sc.next();
            String prefix = city.substring(0, 2);

            if (prefix.equals(state)) continue;

            String code = prefix + state;
            String reverse = state + prefix;

            count += map.getOrDefault(reverse, 0);
            map.put(code, map.getOrDefault(code, 0) + 1);
        }

        System.out.println(count);
    }
}
