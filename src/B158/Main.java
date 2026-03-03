package B158;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        // get input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] input = new int[N][N];
        for (int i = 0;i < N;i++)
            for (int j = 0;j < N;j++)
                input[i][j] = sc.nextInt();

        //test input
        //System.out.println(Arrays.deepToString(input));

        int[][] output = new int[N][N];
        for (int i = 0;i < N;i++)
            for (int j = 0;j < N;j++) {
                int[] values = {i+1, j+1, N-i, N-j};
                int target = Arrays.stream(values).min().getAsInt();
                output[i][j] = input[i][j] - target;
            }
        int sum = Arrays.stream(output)
                .flatMapToInt(Arrays::stream)
                .sum();
        System.out.println(sum);
    }
}
