import java.io.*;
import java.util.*;

public class USACOContest3P1 {
    public static void main(String[] args) throws IOException {
        Kattio sc = new Kattio(System.in);
        int t = sc.nextInt();
        for (int j = 0; j < t; j++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            //idea: iterate through and build a frequency map.
            //then, for each pair, you're going to want to apply the operation once, twice, etc.
            //if the element after applying the operation already exists in the array, subtract again. maintain a current subtract count
            //so that the next element can just do that operation and add once more.
            //update the counts and existence map and set as you go.
            //you may need to change io format.
            if (k == 1) {
                //so were just stupid now.
                long operations = 0;
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
                Arrays.sort(arr);
                int free = arr[0];
                for (int i = 0; i < n; i++) {
                    if (arr[i] < free) {
                        operations += free - arr[i];
                        arr[i] = free;
                    }
                    free = arr[i] + 1;
                }
                System.out.println(operations);
            } else {
                Map<Integer, Integer> freq = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    int x = sc.nextInt();
                    freq.put(x, freq.getOrDefault(x,0) + 1);
                }
                long operations = 0;
                for (int x : new ArrayList<>(freq.keySet())) {
                    if (freq.get(x) >= 2) {
                        int currentchange = 1;
                        while (freq.get(x) != 1) {
                            int value = x + (k * currentchange);
                            while (freq.containsKey(value)) {
                                currentchange++;
                                value = x + (k * currentchange);
                            }
                            freq.put(x, freq.get(x) - 1);
                            freq.put(value, freq.getOrDefault(value,0) + 1);
                            operations += currentchange;
                        }
                    }
                }
                System.out.println(operations);
            }
        }
    }
    static class Kattio extends PrintWriter {
        private StringTokenizer st;
        private BufferedReader r;
        public Kattio(InputStream i) {
            super(new BufferedOutputStream(System.out));
            r = new BufferedReader(new InputStreamReader(i));
        }
        public String next() {
            try {
                while (st == null || !st.hasMoreElements()) st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) { return null; }
        }
        public int nextInt() { return Integer.parseInt(next()); }
    }
}

