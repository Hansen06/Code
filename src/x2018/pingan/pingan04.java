package x2018.pingan;

import java.util.Scanner;

public class pingan04 {

    public static int judge(int year, int month, int date) {
        int i;
        int[] days = {0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = 0;
        if ((year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0))) {
            days[2] = 29;
        } else {
            days[2] = 28;
        }
        for (i = 1; i < month; i++) {
            day += days[i];
        }
        day += date;
        return day;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(judge(y, m, d));
    }
}
