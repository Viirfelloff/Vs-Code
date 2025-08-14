package LeetCodeAndUSACOProblems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
public class USACOLying {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int lower = 0;
        int upper = 0;
        Map<String, Integer> map1 = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String dir = sc.next();
            int range = sc.nextInt();
            if (i == 0) {
                if (dir.equals('G')) {
                    lower = range;
                } else {
                    upper = range;
                }
            } else {

            }
        }
    }
}
