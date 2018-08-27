package x2018;

import java.util.Arrays;
import java.util.Scanner;

public class square_360001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        double[] y = new double[t];
        double[] x = new double[t];
        for (int i = 0; i < t; i++) {
            double fir = sc.nextInt();
            double sec = sc.nextInt();
            x[i] = fir;
            y[i] = sec;
        }
        Arrays.sort(x);
        Arrays.sort(y);
        double max_x = x[t-1];
        double max_y = y[t-1];
        double min_x = x[0];
        double min_y = y[0];

        double width = max_x - min_x;
        double hei = max_y - min_y;
        if(width > hei){
            System.out.println(width*width);
        }else {
            System.out.println(hei*hei);
        }

    }
}
