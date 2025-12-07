package LeetCodeAndUSACOProblems;

import java.io.*;
import java.util.Scanner;

public class USACOSocialDistancingI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("socdist1.in"));
        PrintWriter pr = new PrintWriter(new FileWriter("socdist1.out"));
        int N = Integer.parseInt(br.readLine());
        String s = String.valueOf(br.readLine());
        //essentially, maximize D.
        //to do this, take the current D. D * 2 + 1 is the minimum length of 0 block for preserving D.
        //if none exist, decrease D and repeat.
        //after, its the second cow. repeat the same process.
        br.close();
        pr.flush();
        pr.close();
    }
}
