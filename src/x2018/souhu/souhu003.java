package x2018.souhu;

import java.util.Scanner;

public class souhu003 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {

            String str1 = in.next();
            String str2 = in.next();

            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb1.append(str1);
            sb2.append(str2);

            boolean flag = true;
            if (str1.length() > str2.length()) {
                for (int i = 0; i < (str1.length() - str2.length()) / 2; i++) {
                    sb2.append(".");
                    sb2.append("0");
                }
            } else if (str1.length() < str2.length()) {
                for (int i = 0; i < (str2.length() - str1.length()) / 2; i++) {
                    sb1.append(".");
                    sb1.append("0");
                }
            } else {
                flag = false;
                if (str1.compareTo(str2) < 0) {
                    System.out.println("-1");
                } else if (str1.compareTo(str2) > 0) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }

            if (flag) {
                str1 = sb1.toString();
                str2 = sb2.toString();

                if (str1.compareTo(str2) < 0) {
                    System.out.println("-1");
                } else if (str1.compareTo(str2) > 0) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }
        }
    }
}
