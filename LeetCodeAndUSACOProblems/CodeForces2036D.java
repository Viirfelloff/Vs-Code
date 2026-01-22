import java.util.*;

public class CodeForces2036D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<List<Integer>> grid = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                List<Integer> row = new ArrayList<>();
                String s = sc.next();
                for (char c : s.toCharArray()) {
                    int x = Character.getNumericValue(c);
                    row.add(x);
                }
                grid.add(row);
            }
            //rules - both n and m have to be greater than 3 for there to be more than 1 layer
            //dimensions of next layer = n - 2 by m - 2.
            //for another layer to occur behind that, n - 2 and m - 2 have to be >= 3. so n and m have to be >= 5.
            //and etc. use while loop to determine how many layers are present.
            int startRow = 0;
            int endRow = n;
            int startCol = 0;
            int endCol = m;
            int count = 0;
            while (startRow < endRow && startCol < endCol) {

                int height = endRow - startRow;
                int width = endCol - startCol;
                if (height < 2 || width < 2) break;

                List<Integer> sequence = new ArrayList<>();

                for (int r = startCol; r < endCol; r++)
                    sequence.add(grid.get(startRow).get(r));
                sequence.remove(sequence.size() - 1);

                for (int r = startRow; r < endRow; r++)
                    sequence.add(grid.get(r).get(endCol - 1));
                sequence.remove(sequence.size() - 1);

                for (int r = endCol - 1; r >= startCol; r--)
                    sequence.add(grid.get(endRow - 1).get(r));
                sequence.remove(sequence.size() - 1);

                for (int r = endRow - 1; r >= startRow; r--)
                    sequence.add(grid.get(r).get(startCol));
                sequence.remove(sequence.size() - 1);

                int L = sequence.size();
                if (L >= 4) {
                    for (int iI = 0; iI < 3; iI++)
                        sequence.add(sequence.get(iI));
                    for (int iI = 0; iI + 3 < L + 3; iI++)
                        if (sequence.get(iI) == 1 &&
                                sequence.get(iI + 1) == 5 &&
                                sequence.get(iI + 2) == 4 &&
                                sequence.get(iI + 3) == 3)
                            count++;
                }

                startRow++;
                endRow--;
                startCol++;
                endCol--;
            }
            System.out.println(count);
        }
    }
}
