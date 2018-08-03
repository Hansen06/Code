package offer001;

import java.util.ArrayList;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class Solution050_FirstAppearingOnce {


    private static int map[] = new int[256];
    private static ArrayList<Character> list = new ArrayList<Character>();

    //Insert one char from stringstream
    private static int index = 1;

    //方法不对
    public static void Insert(char ch)
    {
        list.add(ch);
        if (map[ch] == 0){
            map[ch]++;
        }else if (map[ch] >= 1){
            map[ch] = -1;
        }
    }

    public static void Insert2(char ch)
    {
        if (map[ch] == 0){
            map[ch] = index++;  //index一直是自增状态，用来区分字母的输入顺序，用于后期查找谁是第一个满足条件的字母
        }else{
         map[ch] = -1;    //出现的次数大于1词标注为-1，后期查找时就不再考虑该字符
        }
     }

    //方法不对
    public static void Insert1(char ch)
    {
        if (map[ch] == 0){
            list.add(ch);
            map[ch] = 1;
        }else {
            map[ch]++;
        }
    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce1()
    {
        char ch1 = '#';
        for (int i = 0; i < list.size(); i++) {
            char ch = list.get(i);
            if (map[ch] == 1){
               ch1 = ch;
            }
        }
        return ch1;
    }

    public static char FirstAppearingOnce2()
    {
        int temp = Integer.MAX_VALUE;
        char ch = '#';
        for (int i = 0; i < 256; i++) {
            //用来取出首先输入的字母，通过index进行标注谁先进入，map[i]
            if (map[i] != 0 && map[i] != -1 && map[i] < temp){
                temp = map[i];
                ch = (char)i;
            }
        }
        return ch;
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

        char a = 'h';
        char b = 'e';
        char c = 'l';
        char d = 'l';
        char p = 'o';
        char e = 'w';
        char f = 'o';
        char g = 'r';
        char h = 'l';
        char i = 'd';

        Insert2(a);
        System.out.println(FirstAppearingOnce2());

        Insert2(b);
        System.out.println(FirstAppearingOnce2());

        Insert2(c);
        System.out.println(FirstAppearingOnce2());

        Insert2(d);
        System.out.println(FirstAppearingOnce2());

        Insert2(p);
        System.out.println(FirstAppearingOnce2());

        Insert2(e);
        System.out.println(FirstAppearingOnce2());

        Insert2(f);
        System.out.println(FirstAppearingOnce2());

        Insert2(g);
        System.out.println(FirstAppearingOnce2());

        Insert2(h);
        System.out.println(FirstAppearingOnce2());

        Insert2(i);
        System.out.println(FirstAppearingOnce2());

//        Insert1(a);
//        System.out.println(FirstAppearingOnce1());
//
//        Insert1(b);
//        System.out.println(FirstAppearingOnce1());
//
//        Insert1(c);
//        System.out.println(FirstAppearingOnce1());
//
//        Insert1(d);
//        System.out.println(FirstAppearingOnce1());
//
//        Insert1(p);
//        System.out.println(FirstAppearingOnce1());
//
//        Insert1(e);
//        System.out.println(FirstAppearingOnce1());
//
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
