package Offer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class Solution015_FirstAppearingOnce {


    private static int map[] = new int[256];
    private static ArrayList<Character> list = new ArrayList<Character>();

    //Insert one char from stringstream
    public static void Insert(char ch)
    {
        list.add(ch);
        if (map[ch] == 0){
            map[ch]++;
        }else if (map[ch] >= 1){
            map[ch] = -1;
        }
    }

    public static void Insert1(char ch)
    {
        list.add(ch);
        if (map[ch] == 0){
            map[ch] = 1;
        }else {
            map[ch]++;
        }
    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce1()
    {
        for (int i = 0; i < list.size(); i++) {
            char ch = list.get(i);
            if (map[ch] == 1){
               return ch;
            }
        }
        return '#';
    }

    public static char FirstAppearingOnce()
    {
        char c = '#';
        for (int i = 0; i <= list.size(); i++) {
            char ch = list.get(i);
            if (map[ch] == 1){
                c = ch;
                break;
            }
        }
        return c;
    }

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        char ch = (char) scanner.nextInt();
//        Insert(ch);
//        FirstAppearingOnce();

        char a = 'g';
        char b = 'o';
        char c = 'o';
        char d = 'g';
        char p = 'l';
        char e = 'e';
        char f = 'o';
        char g = 'r';
        char h = 'l';
        char i = 'd';

        Insert1(a);
        System.out.println(FirstAppearingOnce1());

        Insert1(b);
        System.out.println(FirstAppearingOnce1());

        Insert1(c);
        System.out.println(FirstAppearingOnce1());

        Insert1(d);
        System.out.println(FirstAppearingOnce1());

        Insert1(p);
        System.out.println(FirstAppearingOnce1());

        Insert1(e);
        System.out.println(FirstAppearingOnce1());

//        Insert1(f);
//        System.out.println(FirstAppearingOnce1());
//
//        Insert1(g);
//        System.out.println(FirstAppearingOnce1());
//
//        Insert1(h);
//        System.out.println(FirstAppearingOnce1());
//
//        Insert1(i);
//        System.out.println(FirstAppearingOnce1());


        System.out.println("---------------------------");
        for (Character ch : list) {
            System.out.println(ch);
        }

    }

}
