import java.util.*;

public class CodeForcesDiv2BB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            List<Integer> list = new ArrayList<>();
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                list.add(sc.nextInt());
            }
            Collections.sort(list);
            boolean valid = true;
            for (int j = 1; j < n; j++) {
                //j (inclusive) and on =  right half
                //before j = left half
                List<Integer> left = new ArrayList<>(list.subList(0,j));
                List<Integer> right = new ArrayList<>(list.subList(j,list.size()));
                int leftMex = getMex(left);
                int rightMex = getMex(right);
                if (leftMex == rightMex) {
                    valid = false;
                    break;
                }
            }
            if (valid) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    public static int getMex(List<Integer> listuh) {
        Set<Integer> set = new HashSet<>(listuh);
        for (int i = 0; i < set.size(); i++) {
            if (!set.contains(i)) return i;
        }
        return set.size();
    }
}

