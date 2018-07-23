package Offer004;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 字符串的排列
 */
public class Solution038_Permutation {

    public ArrayList<String> Permutation(String str) {
        List<String> res = new ArrayList<>();
        if (str != null && str.length() > 0){
            PermutationCore(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return (ArrayList)res;
    }

    private void PermutationCore(char[] chars, int i, List<String> list) {
        if (i == chars.length - 1){
            String val = String.valueOf(chars);
            if (!list.contains(val)){
                list.add(val);
            }
        }else {
            for (int j = i; j < chars.length; j++) {
                swap(chars, i, j);
                PermutationCore(chars, i+1, list);
                swap(chars, i, j);
            }
        }
    }
    public void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
