package B138;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // get input
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();

        char[][] input = new char[H][W];
        for (int i = 0; i < H; i++) {
            String line = sc.next();
            for (int j = 0; j < W; j++) {
                input[i][j] = line.charAt(j);
            }
        }

        int count = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (input[i][j] == '.') {
                    boolean allHash = true;
                    for (int dx = -1; dx <= 1; dx++) {
                        for (int dy = -1; dy <= 1; dy++) {
                            if (dx == 0 && dy == 0) continue;
                            int ni = i + dx;
                            int nj = j + dy;
                            if (ni < 0 || ni >= H || nj < 0 || nj >= W || input[ni][nj] != '#') {
                                allHash = false;
                            }
                        }
                    }
                    if (allHash) count++;
                }
            }
        }
        System.out.println(count);

    }
}
