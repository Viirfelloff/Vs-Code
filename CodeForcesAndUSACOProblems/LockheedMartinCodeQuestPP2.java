import java.util.Scanner;
public class LockheedMartinCodeQuestPP2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            String in = String.valueOf(sc.nextLine());
            String[] vals = in.split(":");
            double v = Double.parseDouble(vals[0]);
            double d = Double.parseDouble(vals[1]);
            double time = d / v;
            if (time <= (double) 1) System.out.println("SWERVE");
            else if (time <= (double) 5) System.out.println("BRAKE");
            else System.out.println("SAFE");
        }
    }
}