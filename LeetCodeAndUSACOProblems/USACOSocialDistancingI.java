package LeetCodeAndUSACOProblems;

import java.io.*;
import java.util.Scanner;

public class USACOSocialDistancingI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("socdist1.in"));
        PrintWriter pr = new PrintWriter(new FileWriter("socdist1.out"));
        int N = Integer.parseInt(br.readLine());
        String s = String.valueOf(br.readLine());
        //we have 2 options here. 1. put both in the same stretch of zeroes. 2. put them in the middle of the 2 longest stretches.
        //test both, and see the maximum distance between both.

    }
}
