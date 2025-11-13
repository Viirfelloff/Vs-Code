import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeForces1989B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String substring = sc.next();
            String subsequence = sc.next();
            List<Character> chars = new ArrayList<>();
            int count = 0;
            for (char c : subsequence.toCharArray()) {
                if (substring.indexOf(c) != -1) {
                    chars.add(c);
                } else count++;
            }
            if (count == 0) System.out.println(substring.length());
            else {
                int curIndex = -1;
                int curLength = -1;
                List<Integer> lengths = new ArrayList<>();
                for (char c : chars) {
                    if (curIndex == -1) {
                        curIndex = substring.indexOf(c);
                        curLength++;
                    } else {
                        int newIndex = substring.indexOf(c, curIndex + 1);
                        if (newIndex < curIndex) {
                            curIndex = -1;
                            lengths.add(curLength);
                            curLength = -1;
                        } else {
                            curIndex = newIndex;
                            curLength++;
                        }
                    }
                }
                if (curLength != -1) lengths.add(curLength);
                if (lengths.isEmpty()) System.out.println(substring.length() + count + chars.size());
                else System.out.println((substring.length() + count + chars.size()) - Collections.max(lengths));
            }
            //go thru chars and see longest sequence thats a part of the substring. then take that length, sub from total list length,
            //and ad dthat difference to the result. bam avaasdifjhaw0ipefwae
        }
    }
}
