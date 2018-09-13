package x2018.souhu;

import java.util.Scanner;

public class souhu001_1 {

    public static boolean checkSam(String stringA, String stringB) {
        if (stringA == null || stringB == null) {
            return false;
        }
        if (stringA.length() != stringB.length()) {
            return false;
        }
        int[] strA = new int[256];
        int[] strB = new int[256];
        for (int i = 0; i < stringA.length(); i++) {
            strA[stringA.charAt(i)]++;
            strB[stringB.charAt(i)]++;
        }
        for (int i = 0; i < 256; i++) {
            if (strA[i] != strB[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIsomorphic1(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)])
                return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str1 = in.next();
            String str2 = in.next();
            if (isIsomorphic1(str1, str2)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }

    }
}
