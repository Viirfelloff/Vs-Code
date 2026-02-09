package CodeForcesAndUSACOProblems;
//literally put me in the hall of fame bro ts took me like 10 mins - 6/26/25
public class CodeForces2117A {
    public static String solution (int buttonTime, int[] doors) {
        int secondsPassed = 0;
        int doorsPassed = 0;
        boolean buttonIsActive = false;
        int onespassed = 0;
        int totalones = 0;
        for (int y : doors) {
            if (y == 1) {
                totalones++;
            }
        }
        for (int x : doors) {
            if (secondsPassed == buttonTime && doorsPassed != doors.length && onespassed != totalones) {
                return "NO";
            }
            if (x == 0) {
                doorsPassed++;
            }
            else {
                buttonIsActive = true;
                doorsPassed++;
                onespassed++;
            }
            if (buttonIsActive) {
                secondsPassed++;
            }
        }
        return "YES";
    }
    public static void main (String[] args) {
        int[] given = {0,1,0,0,1,0,0,1,0,0};
        System.out.println(solution(3, given));
    }
}
