package x2018.xinlang;

/**
 * 最长公共子序列
 * abcd1e1f1
 * bcd2e2f2
 * 5
 */
public class xinlang01 {


    public static int LCSLength(char[] str1, char[] str2, int[][] b) {
        int i, j, length1, length2, len;
        length1 = str1.length;
        length2 = str2.length;

        //双指针的方法申请动态二维数组
        int[][] c = new int[length1 + 1][length1 + 1]; //共有length1+1行
        for (i = 0; i < length1 + 1; i++)
            c[i] = new int[length2 + 1];//共有length2+1列

        for (i = 0; i < length1 + 1; i++)
            c[i][0] = 0;        //第0列都初始化为0
        for (j = 0; j < length2 + 1; j++)
            c[0][j] = 0;        //第0行都初始化为0

        for (i = 1; i < length1 + 1; i++) {
            for (j = 1; j < length2 + 1; j++) {
                if (str1[i - 1] == str2[j - 1])//由于c[][]的0行0列没有使用，c[][]的第i行元素对应str1的第i-1个元素
                {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 0;          //输出公共子串时的搜索方向
                } else if (c[i - 1][j] > c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = 1;
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = -1;
                }
            }
        }
        len = c[length1][length2];
        return len;
    }

    public static void main(String[] args) {
        String str1 = new String("123456abcd567");
        String str2 = new String("234dddabc45678");
    }
}
