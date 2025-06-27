package LeetCodeAndUSACOProblems;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Farmer {
    public static void main(String[] args) {
        System.out.println(solution(7, "ABCDABC"));
    }
    public static int solution (int number, String s) {
        int minLength = s.length();

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            int count = 0;

            for (int j = 0; j <= s.length() - i; j++) {
                if (s.substring(j, j + i).equals(prefix)) {
                    count++;
                }
            }

            if (count == 1) {
                minLength = i;
                break;
            }
        }
        return minLength;
    }
}

