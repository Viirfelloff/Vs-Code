import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeForces1077C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            list.add(x);
            sum += x;
        }
        sc.close();
        //option 1 - remove max and see if the other elements add up to new max
        List<Integer> list2 = new ArrayList<>(list);
        Collections.sort(list2);
        int max = list2.get(list2.size() - 1);
        int max2 = list2.get(list2.size() - 2);
        List<Integer> idxes = new ArrayList<>();
        if (sum - (max) == 2 * max2) idxes.add(list.indexOf(max));
        //option 2 - remove other elements to add up to current max
        //take sum - max, see if equals max. calculate difference. if any one element equals difference, print index
        if (sum != 2 * max) {
            int diff = sum - max;
            int idx = 0;
            for (int x : list) {
                if (x == diff) idxes.add(idx);
                idx++;
            }
        }
        System.out.println(idxes.size());
        for (int y : idxes) System.out.println(y);
    }
}
