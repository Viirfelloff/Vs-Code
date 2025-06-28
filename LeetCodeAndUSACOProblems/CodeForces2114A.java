package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
//ez dubs
public class CodeForces2114A {
    public static void solution(String s) {
        char[] S = s.toCharArray();
        char[] res = new char[3];
        int spaces = 0;
        int inc = 0;
        res[0] = S[0];
        for (char x : S) {
            if (x == ' ') {
                spaces++;
                res[spaces] = S[inc + 1];
            }
            inc++;
        }
        StringBuilder sb = new StringBuilder();
        for (char y : res) {
            sb.append(y);
        }
        String result = new String(sb);
        System.out.println(result);
    }
    public static void main (String[] args) {
        solution("united states america");
    }
}
