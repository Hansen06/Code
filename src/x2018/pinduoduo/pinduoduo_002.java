package x2018.pinduoduo;

import java.util.Scanner;

public class pinduoduo_002 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        char[][] matrix = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = in.next();
            char[] ch = str.toCharArray();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = ch[j];
            }
        }

        for (int j = 0; j < M; j++) {
            if (matrix[N - 1][j] == '.' || matrix[N - 1][j] == 'o') {
                for (int k = N - 2; k >= 0; k--) {
                    if (matrix[k][j] == 'o') {
                        matrix[k][j] = '.';

                    }
                    if (matrix[k][j] == 'x') {
                        break;
                    }
                }
                matrix[N - 1][j] = '.';
            }
        }
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(matrix[i][j]);
//            }
//            System.out.println();
//        }

        for (int i = N - 2; i > 0; i--) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == '.') {
                    for (int k = i - 1; k >= 0; k--) {
                        if (matrix[k][j] == 'o') {
                            matrix[k][j] = '.';
                            matrix[k + 1][j] = 'o';
                        }
                        if (matrix[k][j] == 'x') {
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
