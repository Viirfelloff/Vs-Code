import java.util.*;

public class CALICOP11 {

    static int playTournament(int[] players) {
        int n = players.length;
        int[] current = Arrays.copyOf(players, n);

        while (n > 1) {
            int[] next = new int[n / 2];
            for (int i = 0; i < n; i += 2) {
                if (current[i] > current[i + 1]) next[i / 2] = current[i + 1];
                else next[i / 2] = current[i];
            }
            current = next;
            n = current.length;
        }

        return current[0];
    }

    static void shufflePlayers(int[] arr, int[] P, int k) {
        int n = arr.length;
        int[] temp = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            List<Integer> cycle = new ArrayList<>();
            int cur = i;
            while (!visited[cur]) {
                visited[cur] = true;
                cycle.add(cur);
                cur = P[cur] - 1;
            }
            int len = cycle.size();
            for (int j = 0; j < len; j++) {
                int from = cycle.get(j);
                int to = cycle.get((j + k) % len);
                temp[to] = arr[from];
            }
        }

        System.arraycopy(temp, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int Q = sc.nextInt();
            int[] players = new int[N];
            for (int i = 0; i < N; i++) players[i] = sc.nextInt();
            int[] P = new int[N];
            for (int i = 0; i < N; i++) P[i] = sc.nextInt();

            for (int q = 0; q < Q; q++) {
                int K = sc.nextInt();
                shufflePlayers(players, P, K);
                System.out.println(playTournament(players));
            }
        }
    }
}
