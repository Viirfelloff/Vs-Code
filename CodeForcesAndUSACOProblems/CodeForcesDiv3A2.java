package CodeForcesAndUSACOProblems;

import java.util.*;
//check
public class CodeForcesDiv3A2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list1.add(sc.nextInt());
            }
            for (int m = 0; m < n; m++) {
                list2.add(sc.nextInt());
            }
            int it = 0;
            boolean step1 = true;
            boolean step2 = true;
            while (step1) {
                int inc = 0;
                boolean check = true;
                for (int x : list1) {
                    if (x > list2.get(inc)) {
                        step1 = true;
                        list1.set(inc, x - 1);
                        it++;
                        break;
                    } else {
                        if (inc == list1.size() - 1) {
                            check = false;
                            step1 = false;
                            break;
                        }
                    }
                    inc++;
                }
                int inc2 = 0;
                boolean check2 = true;
                for (int xx : list1) {
                    if (xx < list2.get(inc2)) {
                        step2 = true;
                        list2.set(inc2, xx - 1);
                        it++;
                        break;
                    } else {
                        if (inc2 == list1.size() - 1) {
                            check2 = false;
                            step2 = false;
                            break;
                        }
                    }
                    inc2++;
                }
            }
            System.out.println(it);
        }
    }
}
