package newcoder;

/**
 * 最近公共祖先
 */
public class Solution_getLCA {
    public int getLCA(int a, int b) {
        // write code here
        if (a < 1 || b < 1){
            return -1;
        }
        while (a != b){
            if (a > b){
                a = a / 2;
            }else {
                b = b / 2;
            }
        }
        return a;
    }
}
