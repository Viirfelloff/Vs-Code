import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForcesRound1076B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                list.add(x);
            }
            int current = n;
            int entry = 0;
            for (int x: list) {
                if (x != current) {
                    entry = current;
                    break;
                }
                current--;
            }
            if (entry == 0) {
                for (int x : list) System.out.print(x + " ");
            } else {
                int elementsAlrinplace = n - entry;
                int endIdx = list.indexOf(entry) + 1;
                StringBuilder sb = new StringBuilder();
                for (int x : list) sb.append(x);
                String segment = new String(sb.substring(elementsAlrinplace, endIdx));
                String reversed = new StringBuilder(segment).reverse().toString();
                String prefix = sb.substring(0, elementsAlrinplace);
                String suffix = sb.substring(endIdx);
                String result = prefix + reversed + suffix;
                for (char c : result.toCharArray()) {
                    int x = Character.getNumericValue(c);
                    System.out.print(x + " ");
                }
            }
            System.out.println();
        }
    }
}