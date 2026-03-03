package B157;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // get input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] input = new int[N][K];
        for (int i = 0;i < N;i++)
            for (int j = 0;j < K;j++)
                input[i][j] = sc.nextInt();

        Set<Integer> rows = new HashSet<>();
        for (int j = 0; j < K; j++) {
            int minVal = Integer.MAX_VALUE;
            int minRow = 0;
            for (int i = 0; i < N; i++) {
                if (input[i][j] < minVal) {
                    minVal = input[i][j];
                    minRow = i;
                }
            }
            rows.add(minRow);
        }
        System.out.println(rows.size());
    }
}
