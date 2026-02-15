import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class CodeForces2195B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) list.add(sc.nextInt());
            List<Integer> sorted = new ArrayList<>(list);
            Collections.sort(sorted);
            boolean valid = true;
            for (int j = 0; j < n; j++) {
                if (list.get(j) != sorted.get(j)) {
                    if (j * 2 >= n) {
                        valid = false;
                        break;
                    } else if (list.get(j * 2) == sorted.get(j)) {
                        int temp = list.get(j * 2);
                        list.set(j * 2, list.get(j));
                        list.set(j, temp);
                    } else {
                        valid = false;
                        break;
                    }
                }
            }
            System.out.println(valid ? "YES" : "NO");
        }
    }
}
