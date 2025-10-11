

import java.util.Scanner;

public class CodeForces1941C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i< t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            StringBuilder sb = new StringBuilder();
            int removals = 0;
            int mapie = 0;
            for (int k = 0; k < s.length(); k++) {
                sb.append(s.charAt(k));
                if (sb.length() >= 5 && sb.substring(sb.length() - 5).equals("mapie")) {
                    mapie++;
                }
// Now always check last 3 letters independently
                if (sb.length() >= 3) {
                    String last3 = sb.substring(sb.length() - 3);
                    if (last3.equals("map")) removals++;
                    if (last3.equals("pie")) removals++;
                }
            }
            System.out.println(removals - mapie);
        }
    }
}
