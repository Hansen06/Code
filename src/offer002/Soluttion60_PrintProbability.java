package offer002;

/**
 * n个骰子的点数
 */
public class Soluttion60_PrintProbability {

    static int g_maxValue = 6;
    public static void PrintProbability(int number){
        if (number < 1){
            return;
        }

        int[][] pProbabilities = new int[2][g_maxValue*number+1];
        int flag = 0;
        for (int i = 0; i <= g_maxValue; i++) {
            pProbabilities[flag][i] = 1;
        }

        for (int k = 2; k <= number; k++) {
            for (int i = 0; i < k; i++) {
                pProbabilities[1-flag][i] = 0;
            }

            for (int i = k; i <=g_maxValue*k; i++) {
                pProbabilities[1-flag][i] = 0;
                for (int j = 0; j <= i && j <= g_maxValue ; j++) {
                    pProbabilities[1-flag][i] += pProbabilities[flag][i-j];
                }
            }
            flag = 1-flag;
        }

        double total = Math.pow(g_maxValue, number);
        for (int i = number; i <= g_maxValue*number; i++) {
            double ratio = (double) pProbabilities[flag][i]/total;
            System.out.println(i + " ratio is: " + ratio);
        }
    }

    public static void main(String[] args) {
        PrintProbability(2);
    }
}
