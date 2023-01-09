package random_numbers;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[][] resultmax = new int[B - A + 1][N];
        int[] resultmin = new int[B - A + 1];
        for (int i = 0; i < B  - A + 1; i++) {
            Random random = new Random(i + A);
            for (int j = 0; j < N; j++) {
                resultmax[i][j] = random.nextInt(K);
            }
            Arrays.sort(resultmax[i]);
            resultmin[i] = resultmax[i][N - 1];
        }
        int min = resultmin[0];
        int index = 0;
        for (int i = 0; i < resultmin.length; i++) {
                    if (resultmin[i] < min) {
                        index = i + A;
                        min = resultmin[i];
                    }
        }
        System.out.println(index);
        System.out.println(min);
/*        Arrays.sort(resultmin);
        System.out.println(resultmin[0]);*/


    }
}
