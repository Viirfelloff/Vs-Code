import java.util.*;

public class CALICOP9 {
    static boolean squareFeasible(int fx, int fy,
                                  List<Double> X, List<Double> Y,
                                  List<Double> S,
                                  List<Boolean> awake) {

        List<Integer> awakeIdx = new ArrayList<>();
        List<Integer> sleptIdx = new ArrayList<>();
        int n = X.size();
        for (int i = 0; i < n; i++) {
            if (awake.get(i)) awakeIdx.add(i);
            else sleptIdx.add(i);
        }
        if (awakeIdx.isEmpty()) return false;
        if (sleptIdx.isEmpty()) return false;

        for (int a : awakeIdx) {
            double Xa = X.get(a);
            double Ya = Y.get(a);
            double Ka = S.get(a);
            for (int b : sleptIdx) {
                double Xb = X.get(b);
                double Yb = Y.get(b);
                double Kb = S.get(b);

                double dx = Xb - Xa;
                double dy = Yb - Ya;
                double A = Kb - Ka;
                double Bx = -2 * Kb * Xb + 2 * Ka * Xa;
                double By = -2 * Kb * Yb + 2 * Ka * Ya;
                double C = Kb * (Xb*Xb + Yb*Yb) - Ka * (Xa*Xa + Ya*Ya);

                double[] xs = {fx, fx + 1.0};
                double[] ys = {fy, fy + 1.0};
                double maxVal = Double.NEGATIVE_INFINITY;

                for (double x : xs) {
                    for (double y : ys) {
                        double val = A*(x*x + y*y) + Bx*x + By*y + C;
                        if (val > maxVal) maxVal = val;
                    }
                }

                if (maxVal > 0) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            List<Double> X = new ArrayList<>();
            List<Double> Y = new ArrayList<>();
            List<Double> S = new ArrayList<>();
            List<Boolean> A = new ArrayList<>();

            double minX = Double.POSITIVE_INFINITY;
            double maxX = Double.NEGATIVE_INFINITY;
            double minY = Double.POSITIVE_INFINITY;
            double maxY = Double.NEGATIVE_INFINITY;

            for (int i = 0; i < N; i++) {
                double xi = sc.nextDouble();
                double yi = sc.nextDouble();
                double si = sc.nextDouble();
                String r = sc.next();
                X.add(xi);
                Y.add(yi);
                S.add(si);
                A.add(r.equals("awaken") || r.equals("woke_up"));

                if (xi < minX) minX = xi;
                if (xi > maxX) maxX = xi;
                if (yi < minY) minY = yi;
                if (yi > maxY) maxY = yi;
            }

            int lowX = (int)Math.floor(minX) - 1;
            int highX = (int)Math.ceil(maxX) + 1;
            int lowY = (int)Math.floor(minY) - 1;
            int highY = (int)Math.ceil(maxY) + 1;

            int fx = 0, fy = 0;
            outer:
            for (int i = lowX; i <= highX; i++) {
                for (int j = lowY; j <= highY; j++) {
                    if (squareFeasible(i, j, X, Y, S, A)) {
                        fx = i;
                        fy = j;
                        break outer;
                    }
                }
            }

            System.out.println(fx + " " + fy + " " + (fx + 1) + " " + (fy + 1));
        }
    }
}
