package CodeForcesAndUSACOProblems;
//why is ts a problem
public class CodeForces4A {
    public static String solution (int w) {
        if (w % 2 == 0 && w > 2) return "YES";
        return "NO";
    }
    public static void main (String[] args) {
        System.out.println(solution(8));
    }
}
