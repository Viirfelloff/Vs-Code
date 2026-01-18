import java.util.*;

public class CodeForcesDiv4Contest2C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) list.add(sc.nextInt());
            Collections.sort(list);
            System.out.println(seqs(list));
        }
    }
    public static int seqs(List<Integer> list) {
        Set<Integer> newList = new HashSet<>(list);
        List<Integer> uncopied = new ArrayList<>(newList);
        int maxLen = 1;
        int curLen = 1;
        for (int i = 0; i < uncopied.size() - 1; i++) {
            if (uncopied.get(i + 1) == uncopied.get(i) + 1) {
                curLen++;
            } else {
                curLen = 1;
            }
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }
}
