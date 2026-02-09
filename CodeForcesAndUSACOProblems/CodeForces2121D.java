import java.util.*;

public class CodeForces2121D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                a.add(sc.nextInt());
            }
            for (int j = 0; j < n; j++) {
                b.add(sc.nextInt());
            }
            //iteration sort
            //then swap
            //continue until done
            //if this doesnt work try swapping first
            List<int[]> ops = new ArrayList<>();
            while(!checkValidity(a, b)) {
                //iteration sort, and then iterate and swap
                //step 1: iteration sort
                while (!sorted(a)) {
                    for (int j = 0; j < a.size() - 1; j++) {
                        int diff = a.get(j) - a.get(j + 1);
                        if (diff > 0) {
                            //swap
                            int temp = a.get(j);
                            a.set(j, a.get(j + 1));
                            a.set(j + 1, temp);
                            ops.add(new int[]{1,j});
                        }
                    }
                }
                while (!sorted(b)) {
                    for (int j = 0; j < b.size() - 1; j++) {
                        int diff = b.get(j) - b.get(j + 1);
                        if (diff > 0) {
                            //swap
                            int temp = b.get(j);
                            b.set(j, b.get(j + 1));
                            b.set(j + 1, temp);
                            ops.add(new int[]{2,j});
                        }
                    }
                }
                //step 2: swap
                for (int j = 0; j < n; j++) {
                    if (a.get(j) >= b.get(j)) {
                        int temp = a.get(j);
                        a.set(j, b.get(j));
                        b.set(j, temp);
                        ops.add(new int[]{3,j});
                    }
                }
            }
            System.out.println(ops.size());
            for (int[] op : ops) {
                System.out.println(op[0] + " " + (op[1] + 1));
            }
        }
    }
    public static boolean checkValidity(List<Integer> a, List<Integer> b) {
        boolean valid = true;
        List<Integer> asort = new ArrayList<>(a);
        List<Integer> bsort = new ArrayList<>(b);
        Collections.sort(asort);
        Collections.sort(bsort);
        for (int i = 0; i < a.size(); i++) {
            if (!((Objects.equals(a.get(i), asort.get(i))) && (Objects.equals(b.get(i), bsort.get(i))) && a.get(i) < b.get(i))) {
                valid = false;
                break;
            }
        }
        return valid;
    }
    public static boolean sorted(List<Integer> a) {
        boolean valid = true;
        List<Integer> asort = new ArrayList<>(a);
        Collections.sort(asort);
        for (int i = 0; i < a.size(); i++) {
            if (!(Objects.equals(a.get(i), asort.get(i)))) {
                valid = false;
                break;
            }
        }
        return valid;
    }
}
