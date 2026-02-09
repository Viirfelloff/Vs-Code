package CodeForcesAndUSACOProblems;
//big brain activities
public class USACOTheLostCow {
    //x is loop. 2^x is the amount moved. if x % 2 = 0, add. if not, subtract.
    public static int solution(int johnpos, int cowpos) {
        int loop = 0;
        int pos = johnpos;
        int steps = 0;
        while (pos != cowpos) {
            if (loop % 2 == 0) {
                int target = johnpos + (int) Math.pow(2, loop);
                while (pos != target) {
                    pos++;
                    steps++;
                    if (pos == cowpos) {
                        return steps;
                    }
                }
            } else {
                int target2 = johnpos - (int) Math.pow(2, loop);
                while (pos != target2) {
                    pos--;
                    steps++;
                    if (pos == cowpos) {
                        return steps;
                    }
                }
            }
            loop++;
        }
        return 0;
    }
    public static void main (String[] args) {
        System.out.println(solution(3,6));
    }
}
