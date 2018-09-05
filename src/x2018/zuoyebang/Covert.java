package x2018.zuoyebang;

import java.util.Scanner;

public class Covert {


    public static String converCore(String sub){
        char[] ch = sub.toCharArray();
        String res = "";
        //数字对应的汉字
        String[] num = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        //单位
        String[] unit = {"", "十", "百", "千", "万", "十万", "百万", "千万", "亿", "十亿", "百亿", "千亿", "万亿"};

        int length = ch.length - 1;
        int index = 0;
        if (ch[0] == '+'){
            res += "正";
            index++;
        }
        if (ch[0] == '-'){
            res += "负";
            index++;
        }
        for (; index <= length; index++) {
            int c = (int) ch[index] - 48;
            if (c != 0) {
                res += num[c] + unit[length - index];
            } else {
                if (index == length) {

                } else {
                    if (ch[index + 1] != '0') {
                        res += num[c];
                    }
                }
            }
        }
        return res;
    }

    public static String convert(String number) {
        String res = "";
        if (number == null || number.length() < 1){
            res = "err";
            return res;
        }
        char[] ch = number.toCharArray();
        if (ch[0] == 46){
            res = "err";
            return res;
        }

        boolean flag = false;
        int pos = -1;
        if (ch[0] != 43 && ch[0] != 45){
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == '.'){
                    flag = true;
                    pos = i;
                    continue;
                }else if (ch[i] < 48 || ch[i] > 57){
                    res = "err";
                    return res;
                }
            }
        }

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '.') {
                pos = i;
                flag = true;
                break;
            }
        }
        String[] num = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

        if (flag){
            StringBuilder str1 = new StringBuilder();
            for (int i = 0; i < pos; i++) {
                str1.append(ch[i]);
            }

            StringBuilder str2 = new StringBuilder();
            for (int i = pos + 1; i < ch.length; i++) {
                str2.append(num[ch[i] - 48]);
            }
            String str3 = "";
            if (pos == 1 && ch[0] == 48){
                str3 = "零";
            }else {
                str3 = converCore(str1.toString());
            }
            res = str3 + "点零" + str2.toString();
        }else {
            res = converCore(number);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String str = scanner.next();
            System.out.println(convert(str));
        }

    }
}
