package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//completely fucking failed agian, u cant even solve a super easy 1100, ur stupid as fuck. quit.
public class CodeForces2112B {
    public static boolean inRange(int upper, int lower, int num) {
        return (num >= lower) && (num <= upper);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> nums = new ArrayList<>();
            for (int j = 0; j < n; j++) nums.add(sc.nextInt());
            if (n == 2) {
                System.out.println(-1);
            } else {
                boolean valid = false;
                for (int k = 0; k < n - 1; k++) {
                    int diff = Math.abs(nums.get(k) - nums.get(k + 1));
                    //k == 0, check only to right
                    //k == n - 2, check only to left
                    //else, check the right element by 2 indices and left by 1 index
                    if (diff <= 1) {
                        valid = true;
                        break;
                    } else {
                        if (k == 0) {
                            //right by 2
                            int element = nums.get(k + 2);
                            int upperRange = Math.max(nums.get(k), nums.get(k + 1));
                            int lowerRange = Math.min(nums.get(k), nums.get(k + 1));
                            int pos1 = element - 1;
                            int pos2 = element + 1;
                            int pos3 = element;
                            if (inRange(upperRange, lowerRange, pos1) || inRange(upperRange, lowerRange, pos2) || inRange(upperRange, lowerRange, pos3)) {
                                valid = true;
                                break;
                            }
                        }
                        else if (k == n - 2) {
                            //left by 1
                            int element = nums.get(k - 1);
                            int upperRange = Math.max(nums.get(k), nums.get(k + 1));
                            int lowerRange = Math.min(nums.get(k), nums.get(k + 1));
                            int pos1 = element - 1;
                            int pos2 = element + 1;
                            int pos3 = element;
                            if (inRange(upperRange, lowerRange, pos1) || inRange(upperRange, lowerRange, pos2) || inRange(upperRange, lowerRange, pos3)) {
                                valid = true;
                                break;
                            }
                        } else {
                            int element1 = nums.get(k - 1);
                            int element2 = nums.get(k + 2);
                            int upperRange = Math.max(nums.get(k), nums.get(k + 1));
                            int lowerRange = Math.min(nums.get(k), nums.get(k + 1));
                            int pos1e1 = element1 - 1;
                            int pos2e1 = element1 + 1;
                            int pos3e1 = element1;
                            int pos1e2 = element2 - 1;
                            int pos2e2 = element2 + 1;
                            int pos3e2 = element2;
                            if (inRange(upperRange, lowerRange, pos1e1) || inRange(upperRange, lowerRange, pos2e1) || inRange(upperRange, lowerRange, pos3e1)) {
                                valid = true;
                                break;
                            }
                            if (inRange(upperRange, lowerRange, pos1e2) || inRange(upperRange, lowerRange, pos2e2) || inRange(upperRange, lowerRange, pos3e2)) {
                                valid = true;
                                break;
                            }
                        }
                    }
                }
                if (valid) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}
