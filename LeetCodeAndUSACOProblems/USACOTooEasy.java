package LeetCodeAndUSACOProblems;

public class USACOTooEasy {
    public static int[] solution (int n, int x, int[] values) {
        int inc1 = 0;
        for (int k : values) {
            int inc2 = 0;
            for (int y : values) {
                if (k + y == x && inc1 != inc2) {
                    return new int[]{inc1 + 1, inc2 + 1};
                }
                inc2++;
            }
            inc1++;
        }
        return new int[]{-1};
    }
    public static void main (String[] args) {
        int[] res = solution(4,8,new int[]{2,7,5,1});
        for (int j : res) {
            System.out.println(Integer.toString(j));
        }
    }
}
