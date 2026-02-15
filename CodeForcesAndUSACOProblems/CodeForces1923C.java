import java.util.*;
public class CodeForces1923C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            List<Long> list = new ArrayList<>();
            List<Long> pf = new ArrayList<>();
            List<Integer> ones = new ArrayList<>();
            int one = 0;
            long sum = 0;
            for (int j = 0; j < n; j++) {
                long x = sc.nextLong();
                sum += x;
                pf.add(sum);
                if (x == 1) one++;
                ones.add(one);
                list.add(x);
            }
            if (n == 2) {
                for (int j = 0; j < q; j++) {
                    int[] query = new int[]{sc.nextInt() - 1, sc.nextInt() - 1};
                    if (query[1] - query[0] == 0) System.out.println("NO");
                    else {
                        if (!Objects.equals(list.get(0), list.get(1))) System.out.println("YES");
                        else {
                            if (list.get(0) == 1 && list.get(1) == 1) System.out.println("NO");
                            else System.out.println("YES");
                        }
                    }
                }
            } else {
                for (int j = 0; j < q; j++) {
                    int[] query = new int[]{sc.nextInt() - 1, sc.nextInt() - 1}; //0 indexed
                    if (query[1] - query[0] == 0) System.out.println("NO");
                    else {
                        //long desiredsum = pf.get(query[1]) - pf.get(query[0]);
                        long desiredsum = pf.get(query[1]) - (query[0] > 0 ? pf.get(query[0] - 1) : 0);
                        long onecount = ones.get(query[1]) - (query[0] > 0 ? ones.get(query[0] - 1) : 0);
                        //long onecount = ones.get(query[1]) - ones.get(query[0]);
                        long largest = desiredsum - (query[1] - query[0]);
                        if (onecount == 0) {
                            //this logic is a little broken but lets hope it works
                            System.out.println("YES");
                        } else {
                            long conflict = 0;
                            //int offset = list.get(query[1]) == 1 ? 1 : 0;
                            int offset = onecount > 0 ? 1 : 0;
                            if (largest - (onecount - (long) offset) < 0) System.out.println("NO");
                            else {
                                conflict += onecount - (long)offset;
                                if (largest - (onecount - (long)offset) == 1) {
                                    System.out.println("NO");
                                } else System.out.println(largest - conflict > 0 ? "YES" : "NO");
                            }
                        }
                    }
                }
            }
        }
    }
}
