import java.io.*;
import java.util.*;
//holy shit full solve first try damnnnnnn
public class USACOModernArt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("art.in"));
        PrintWriter pr = new PrintWriter(new FileWriter("art.out"));
        int n = Integer.parseInt(br.readLine());
        int poss = 0;
        List<List<Integer>> grid = new ArrayList<>();
        Set<Integer> colors = new HashSet<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            String s = br.readLine();
            for (char c : s.toCharArray()) {
                int x = Character.getNumericValue(c);
                if (x != 0) colors.add(x);
                row.add(x);
            }
            grid.add(row);
        }
        Map<Integer, List<int[]>> pts = new HashMap<>();
        for (int color : colors) {
            List<Integer> xvalues = new ArrayList<>();
            List<Integer> yvalues = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid.get(i).get(j) == color) {
                        xvalues.add(j);
                        yvalues.add(i);
                    }
                }
            }
            pts.put(color, Arrays.asList(new int[]{Collections.min(xvalues), Collections.min(yvalues)}, new int[]{Collections.max(xvalues), Collections.max(yvalues)}));
        }
        for (int color : colors) {
            List<int[]> points = pts.get(color);
            boolean valid = true;
            for (int other : colors) {
                if (other != color) {
                    List<int[]> pts2 = pts.get(other);
                    int[] topleft = pts2.get(0);
                    int[] bottomright = pts2.get(1);
                    for (int x = topleft[0]; x <= bottomright[0]; x++) {
                        for (int y = topleft[1]; y <= bottomright[1]; y++) {
                            if (inRect(points, x, y)) {
                                if (grid.get(y).get(x) == color) {
                                    valid = false;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (valid) poss++;
        }
        pr.println(poss);
        pr.flush();
        pr.close();
        br.close();
    }
    public static boolean inRect(List<int[]> points, int x, int y) {
        int[] topleft = points.get(0);
        int[] bottomright = points.get(1);
        return ((x >= topleft[0]) && (x <= bottomright[0])) && ((y >= topleft[1]) && y <= bottomright[1]);
    }
}
