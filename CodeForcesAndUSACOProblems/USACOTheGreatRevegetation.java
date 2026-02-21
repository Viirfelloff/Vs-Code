import java.io.*;
import java.util.*;
public class USACOTheGreatRevegetation {
    public static int newcolor = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
        PrintWriter pr = new PrintWriter(new FileWriter("revegetate.out"));
        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int q = Integer.parseInt(nums[1]);
        List<int[]> req = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            String[] line = br.readLine().split(" ");
            int[] arr = new int[]{Integer.parseInt(line[0]) - 1, Integer.parseInt(line[1]) - 1};
            Arrays.sort(arr);
            req.add(arr);
        }
        int[] seq = new int[n];
        Set<String> lookup = new HashSet<>();
        for (int[] arr : req) {
            StringBuilder sb = new StringBuilder();
            sb.append(arr[0]);
            sb.append(",");
            sb.append(arr[1]);
            lookup.add(sb.toString());
        }
        Map<Integer, Set<Integer>> colortoidx = new HashMap<>();
        colortoidx.put(1, new HashSet<>());
        colortoidx.put(2, new HashSet<>());
        colortoidx.put(3, new HashSet<>());
        colortoidx.put(4, new HashSet<>());
        for (int i = 0; i < q; i++) {
            int[] query = req.get(i);
                if (i == 0) {
                    seq[query[0]] = newcolor;
                    Set<Integer> set = colortoidx.get(seq[query[0]]);
                    set.add(query[0]);
                    colortoidx.put(seq[query[0]], set);
                    update();
                    seq[query[1]] = newcolor;
                    Set<Integer> set2 = colortoidx.get(seq[query[1]]);
                    set2.add(query[1]);
                    colortoidx.put(seq[query[1]], set2);
                    update();
                } else {
                    if (seq[query[0]] == 0 && seq[query[1]] == 0) {
                        boolean val = false;
                        for (int color = 1; color <= 4; color++) {
                            boolean valid = true;
                            Set<Integer> indices = colortoidx.get(color);
                            for (int index : indices) {
                                int[] look = new int[]{index, query[0]};
                                Arrays.sort(look);
                                StringBuilder sb = new StringBuilder();
                                sb.append(look[0]);
                                sb.append(",");
                                sb.append(look[1]);
                                if (lookup.contains(sb.toString())) {
                                    valid = false;
                                    break;
                                }
                            }
                            if (valid) {
                                val = true;
                                seq[query[0]] = color;
                                Set<Integer> indic = colortoidx.get(color);
                                indic.add(query[0]);
                                colortoidx.put(color, indic);
                                break;
                            }
                        }
                        if (!val) {
                            seq[query[0]] = newcolor;
                            Set<Integer> indic = colortoidx.get(newcolor);
                            indic.add(query[0]);
                            colortoidx.put(newcolor, indic);
                            if (newcolor < 4) newcolor++;
                        }
                        boolean val2 = false;
                        for (int color = 1; color <= 4; color++) {
                            if (color != seq[query[0]]) {
                                boolean valid = true;
                                Set<Integer> indices = colortoidx.get(color);
                                for (int index : indices) {
                                    int[] look = new int[]{index, query[1]};
                                    Arrays.sort(look);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(look[0]);
                                    sb.append(",");
                                    sb.append(look[1]);
                                    if (lookup.contains(sb.toString())) {
                                        valid = false;
                                        break;
                                    }
                                }
                                if (valid) {
                                    val2 = true;
                                    seq[query[1]] = color;
                                    Set<Integer> indic = colortoidx.get(color);
                                    indic.add(query[1]);
                                    colortoidx.put(color, indic);
                                    break;
                                }
                            }
                        }
                        if (!val2) {
                            seq[query[1]] = newcolor;
                            Set<Integer> indic = colortoidx.get(newcolor);
                            indic.add(query[1]);
                            colortoidx.put(newcolor, indic);
                            if (newcolor < 4) newcolor++;
                        }
                    } else if (seq[query[0]] == 0 || seq[query[1]] == 0) {
                        int filledidx = seq[query[0]] != 0 ? query[0] : query[1];
                        int notfilledidx = seq[query[0]] != 0 ? query[1] : query[0];
                        boolean val = false;
                        for (int color = 1; color <= 4; color++) {
                            if (color != seq[filledidx]) {
                                boolean valid = true;
                                Set<Integer> indices = colortoidx.get(color);
                                for (int index : indices) {
                                    int[] look = new int[]{index, notfilledidx};
                                    Arrays.sort(look);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(look[0]);
                                    sb.append(",");
                                    sb.append(look[1]);
                                    if (lookup.contains(sb.toString())) {
                                        valid = false;
                                        break;
                                    }
                                }
                                if (valid) {
                                    val = true;
                                    seq[notfilledidx] = color;
                                    Set<Integer> indic = colortoidx.get(color);
                                    indic.add(notfilledidx);
                                    colortoidx.put(color, indic);
                                    break;
                                }
                            }
                        }
                        if (!val) {
                            seq[notfilledidx] = newcolor;
                            Set<Integer> indic = colortoidx.get(newcolor);
                            indic.add(notfilledidx);
                            colortoidx.put(newcolor, indic);
                            if (newcolor < 4) newcolor++;
                        }
                    }
                }
        }
        List<Integer> appear = new ArrayList<>();
        Set<Integer> looku = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!looku.contains(seq[i])) {
                looku.add(seq[i]);
                appear.add(seq[i]);
            }
        }
        int curcolor = 1;
        for (int occ : appear) {
            if (occ != curcolor) {
                seq = swap(seq, occ, curcolor, colortoidx);
                int temp = appear.indexOf(occ);
                appear.set(appear.indexOf(curcolor), occ);
                appear.set(temp, curcolor);
                for (int color = 1; color <= 4; color++) {
                    Set<Integer> in = new HashSet<>();
                    for (int i = 0; i < seq.length; i++) {
                        if (seq[i] == color) in.add(i);
                    }
                    colortoidx.put(color,in);
                }
            }
            curcolor++;
        }
        for (int i = 0; i < n; i++) {
            int lim = seq[i];
            for (int c = 1; c < lim; c++) {
                Set<Integer> indices = colortoidx.get(c);
                boolean valid = true;
                for (int x : indices) {
                    int[] arr = new int[]{x, i};
                    Arrays.sort(arr);
                    String s = arr[0] + "," + arr[1];
                    if (lookup.contains(s)) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    seq[i] = c;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int x : seq) sb.append(x);
        pr.println(sb.toString());
        pr.flush();
        br.close();
        pr.close();
    }
    public static void update() {
        if (newcolor < 4) newcolor++;
    }
    public static int[] swap(int[] arr, int color1, int color2, Map<Integer, Set<Integer>> colortoidx) {
        Set<Integer> c1 = colortoidx.get(color1);
        Set<Integer> c2 = colortoidx.get(color2);
        for (int x : c1) arr[x] = color2;
        for (int x : c2) arr[x] = color1;
        return arr;
    }
}
