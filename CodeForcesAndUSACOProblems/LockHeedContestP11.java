import java.util.Scanner;
public class LockHeedContestP11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        double gm = 6.673e-11 * 5.98e24;
        for (int i = 0; i < t; i++) {
            double h = Double.parseDouble(sc.nextLine());
            double r = 6.37e6 + h;
            double v = Math.sqrt(gm / r);
            double per = Math.sqrt((4 * Math.pow(Math.PI, 2) * Math.pow(r, 3)) / gm);
            long rper = Math.round(per);
            long hrs = rper / 3600;
            long min = (rper % 3600) / 60;
            long s = rper % 60;
            StringBuilder hhmmss = new StringBuilder();
            hhmmss.append(hrs).append(":");
            String mn = Long.toString(min);
            if (mn.length() == 1) hhmmss.append(0);
            hhmmss.append(mn).append(":");
            String st = Long.toString(s);
            if (st.length() == 1) hhmmss.append(0);
            hhmmss.append(st);
            System.out.println((int) Math.round(v) + " " + hhmmss.toString());
        }
    }
}