package CodeForcesAndUSACOProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//yay!
public class USACODaisyChains {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = n;
        ArrayList<Integer> petals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            petals.add(sc.nextInt());
        }
        for (int j = 0; j < petals.size(); j++) {
            List<Integer> subarray = new ArrayList<>();
            subarray.add(petals.get(j));
            int sum = petals.get(j);
            for (int k = j + 1; k < petals.size(); k++) {
                sum += petals.get(k);
                subarray.add(petals.get(k));
                int length = subarray.size();
                if (sum % length != 0) continue;
                int target = sum / length;
                boolean valid = false;
                for (int x : subarray) {
                    if (x == target) {
                        valid = true;
                        break;
                    }
                }
                if (valid) count++;
            }
        }
        System.out.println(count);
    }
}
