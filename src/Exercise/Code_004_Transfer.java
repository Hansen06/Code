package Exercise;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Code_004_Transfer {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String tansform(long number) {

        String str = String.valueOf(number);
        String result = readNum(str);

        System.out.println(result);

        String[] arr = result.split("");
        StringBuilder strin = new StringBuilder();
        for (int i = 0; i < arr.length-1; i++) {
            strin.append(arr[i]);
            if(arr[i].equals("亿") || arr[i].equals("万")){
                strin.append(",");
            }
        }
        strin.append(arr[arr.length-1]);
        return strin.toString();
    }

    public static String readNum(String s){
        String[] unitStrings = {"","十","百","千","万","十","百","千","亿","十"};
        String[] num = {"零","一","二","三","四","五","六","七","八","九"};
        StringBuilder rst = new StringBuilder();
        int len = s.length();
        int index = s.length() - 1;
        while(index >= 0){
            int curNum = Integer.valueOf(s.charAt(index) + "");
            if(curNum != 0){
                rst.insert(0, unitStrings[len-index-1]);
                rst.insert(0, num[curNum]);
            }else {
                if(rst.length()!= 0 && rst.charAt(0)!= '零' && rst.charAt(0)!='万'
                        && rst.charAt(0) != '亿'){
                    rst.insert(0, num[curNum]);
                }
                if(unitStrings[len-index-1].equals("万") || unitStrings[len-index-1].equals("亿")){
                    rst.insert(0, unitStrings[len-index-1]);
                }
            }
            index--;
        }
        return rst.toString();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        long _number;
        _number = Long.parseLong(in.nextLine().trim());

        res = tansform(_number);
        System.out.println(res);

    }
}
