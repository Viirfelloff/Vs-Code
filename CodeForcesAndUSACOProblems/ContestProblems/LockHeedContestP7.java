import java.util.Scanner;
public class LockHeedContestP7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            int w = Integer.parseInt(sc.nextLine());
            double mercury = w * 0.377;
            double venus = w * 0.905;
            double mars = w * 0.379;
            double jupiter = w * 2.528;
            double saturn = w * 1.065;
            double uranus = w * 0.886;
            double neptune = w * 1.137;
            double mercuryrounded = Math.round(mercury * 10.0) / 10.0;
            double venusrounded = Math.round(venus * 10.0) / 10.0;
            double marsrounded = Math.round(mars * 10.0) / 10.0;
            double jupiterrounded = Math.round(jupiter * 10.0) / 10.0;
            double saturnrounded = Math.round(saturn * 10.0) / 10.0;
            double uranusrounded = Math.round(uranus * 10.0) / 10.0;
            double neptunerounded = Math.round(neptune * 10.0) / 10.0;
            System.out.println("Mercury: " + mercuryrounded);
            System.out.println("Venus: " + venusrounded);
            System.out.println("Earth: " + (double) w);
            System.out.println("Mars: " + marsrounded);
            System.out.println("Jupiter: " + jupiterrounded);
            System.out.println("Saturn: " + saturnrounded);
            System.out.println("Uranus: " + uranusrounded);
            System.out.println("Neptune: " + neptunerounded);
        }
    }
}
