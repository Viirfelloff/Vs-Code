package LeetCodeAndUSACOProblems;

public class USACOSpeedingTicket {
    public static int solution(int m, int n, int[] aclengths, int[] acspeeds, int[] besspeeds, int[] beslengths) {
        int counter = 0;
        int counter2 = 0;
        int currentlength = aclengths[counter2];
        int beslength = beslengths[counter];
        int maxOver = 0;
        while (counter < m && counter2 < n) {
            int diff = besspeeds[counter] - acspeeds[counter2];
            if (diff > 0) {
                maxOver = Math.max(maxOver, diff);
            }
            if (beslength < currentlength) {
                currentlength -= beslength;
                counter++;
                if (counter < m) beslength = beslengths[counter];
            } else if (beslength > currentlength) {
                beslength -= currentlength;
                counter2++;
                if (counter2 < n) currentlength = aclengths[counter2];
            } else {
                counter++;
                counter2++;
                if (counter < m) beslength = beslengths[counter];
                if (counter2 < n) currentlength = aclengths[counter2];
            }
        }
        return maxOver;
    }
    public static void main(String[] args) {
        System.out.println(solution(3,3, new int[]{40,50,10}, new int[]{75,35,45},new int[]{76,30,40},new int[]{40,20,40}));
    }
}