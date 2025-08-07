package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
//fuck this shit man its too hard

//revisit when ready
public class USACOLogicalMoos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        String s = sc.next();
        ArrayList<String> list = new ArrayList<>(Arrays.asList(s.split(" ")));
        ArrayList<int[]> querypos = new ArrayList<>();
        ArrayList<String> queryeval = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            querypos.add(new int[]{x,y});
            queryeval.add(sc.next());
        }
        for (int j = 0; j < querypos.size(); j++) {
            if (querypos.get(j)[0] == querypos.get(j)[1]) {
                if (list.get(querypos.get(j)[0] - 1) == queryeval.get(j)) {
                    sb.append("Y");
                } else {
                    sb.append("N");
                }
            } else {
                Stack<String> stack1 = new Stack<>();
                //Two stack evaluations
                int starting = querypos.get(j)[0] - 1;
                int ending = querypos.get(j)[1] - 1;
                for (int k = starting; k <= ending; k++) {
                    if (list.get(k).equals("true") || list.get(k).equals("false")) {
                        stack1.push(list.get(k));
                    } else if (list.get(k).equals("and")) {
                        boolean first = Boolean.parseBoolean(stack1.pop());
                        boolean last = Boolean.parseBoolean(list.get(k + 1));
                        stack1.push(String.valueOf(first && last));
                    } else {
                        stack1.push("or");
                    }
                }
                //Second evaluation

            }
        }
    }
}
