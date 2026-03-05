package B145;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // get input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        // ビンゴカード読み取り
        int[][] card = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                card[i][j] = sc.nextInt();

        // 抽選番号
        HashSet<Integer> drawn = new HashSet<>();
        drawn.add(0); // 中央の0は最初から開けられている
        for (int k = 0; k < K; k++)
            drawn.add(sc.nextInt());

        // 各マスが開いているかの判定
        boolean[][] open = new boolean[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                open[i][j] = drawn.contains(card[i][j]);

        // ビンゴ数をカウント
        int bingo = 0;

        // 横方向
        for (int i = 0; i < N; i++) {
            boolean line = true;
            for (int j = 0; j < N; j++)
                if (!open[i][j]) { line = false; break; }
            if (line) bingo++;
        }

        // 縦方向
        for (int j = 0; j < N; j++) {
            boolean line = true;
            for (int i = 0; i < N; i++)
                if (!open[i][j]) { line = false; break; }
            if (line) bingo++;
        }

        // 左上→右下の対角線
        boolean diag1 = true;
        for (int i = 0; i < N; i++)
            if (!open[i][i]) { diag1 = false; break; }
        if (diag1) bingo++;

        // 右上→左下の対角線
        boolean diag2 = true;
        for (int i = 0; i < N; i++)
            if (!open[i][N - 1 - i]) { diag2 = false; break; }
        if (diag2) bingo++;

        System.out.println(bingo);
    }
}
