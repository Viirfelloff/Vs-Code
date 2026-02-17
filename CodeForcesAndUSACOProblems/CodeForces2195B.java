import java.util.*;

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
            for (int j = 0; j < n / 2; j++) {
                if (!Objects.equals(list.get(j), sorted.get(j))) {
                   if (Objects.equals(list.get(((j + 1) * 2) - 1), sorted.get(j))) {
                        int temp = list.get(((j + 1) * 2) - 1);
                        list.set(((j + 1) * 2) - 1, list.get(j));
                        list.set(j, temp);
                    } else {
                        valid = false;
                        break;
                    }
                }
            }
            if (!valid) System.out.println("NO");
            else {
                boolean equal = Objects.equals(list, sorted);
                System.out.println(equal ? "YES" : "NO");
            }
        }
    }
}
