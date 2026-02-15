import java.util.*;
public class CodeForces2154C1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            int evens = 0;
            int odds = 0;
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                list.add(x);
                if (x % 2 == 0) evens++;
                else odds++;
            }
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) set.add(sc.nextInt());
            if (evens >= 2) System.out.println(0);
            //else if (checkmultiples(list, false)) System.out.println(0);
            else {
                if (evens == 1 && odds >= 1) System.out.println(1);
                else if (evens == 0 && odds >= 2) System.out.println(2);
            }
        }
    }
    public static boolean checkmultiples(List<Integer> list, boolean alt) {
        Set<Integer> set = new HashSet<>(list);
        //for now, iterate through each value and see if it is gcd > 1.
        //optional optimization: for each value iterate through possible multiples
        //and see if the list contains one.
        //implementation 1:
        for (int j = 0; j < list.size(); j++) {
            for (int i = 0; i < list.size(); i++) {
                if (i != j && list.get(i) != 1 && list.get(j) != 1) {
                    boolean gcd;
                    if (list.get(j) > list.get(i)) {
                        if (alt) gcd = list.get(j) % (list.get(i) + 1) == 0;
                        else gcd = list.get(j) % list.get(i) == 0;
                    }
                    else {
                        if (alt) gcd = (list.get(i) + 1) % list.get(j) == 0;
                        else gcd = list.get(i) % list.get(j) == 0;
                    }
                    if (gcd) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}