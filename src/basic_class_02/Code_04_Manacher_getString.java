package basic_class_02;

/**
 * 返回最长回文子串
 */
public class Code_04_Manacher_getString {

    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static String[] maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return new String[]{"0", null};
        }

        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length]; //记录回文半径
        int index = -1;  //记录最右回文边界对应的回文中心
        int pR = -1;  //记录回文最右边界
        int max = Integer.MIN_VALUE;

        int max_All = Integer.MIN_VALUE;
        int max_index = -1;

        for (int i = 0; i != charArr.length; i++) {
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }
            if (i + pArr[i] > pR) {
                pR = i + pArr[i]; //更新最右回文边界
                index = i; // 更新回文中心
            }

            max = Math.max(max, pArr[i]);
            if (max > max_All) {
                max_All = max;
                max_index = index;
            }
        }
        StringBuilder sb = new StringBuilder();
        int start = max_index - max_All + 1;
        for (int i = 0; i < max_All; i++) {
            sb.append(charArr[2*i+1 + start]);
        }

//		String sub = getMaxSub(pArr, max, String.valueOf(charArr));
        return new String[]{String.valueOf(max - 1), sb.toString()};
    }

    public static String getMaxSub(int[] pArr, int len, String str) {
        int centor = 0;
        int maxN = pArr[0];
        for (int i = 0; i < pArr.length; i++) {
            if (pArr[i] > maxN) {
                maxN = pArr[i];
                centor = i;
            }
        }
        String res = str.substring(centor - len + 1, centor + len);
        StringBuilder sb = new StringBuilder();
        char[] ch = res.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != '#') {
                sb.append(ch[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        String str2 = "abc121cba";
        String[] res1 = maxLcpsLength(str1);
        String[] res2 = maxLcpsLength(str2);
        System.out.println(res1[0] + " " + res1[1]);
        System.out.println(res2[0] + " " + res2[1]);
    }

}
