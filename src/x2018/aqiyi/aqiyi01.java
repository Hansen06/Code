package x2018.aqiyi;

import java.util.*;

/**
 * 局长有N种食物，每种食物有Ai份。
 *
 * 每天局长会吃一份食物，或者买一份食物（即每天只能进行吃或买其中的一种动作），这样过了M天
 *
 * 现在局长想知道M天后第p种食物的份数排名（从大到小，相同算并列，例如3 3 2，则排名为1 1 3）
 *
 * N,M,P<=100,Ai<=1000
 *
 * 第一行N M P
 *
 * 第二行N个数Ai
 *
 * 接下来M行，每行A i或者B i分别表示买一份食物i，吃一份食物i
 *
 * 例
 * 3 4 2
 * 5 3 1
 * B 1
 * A 2
 * A 2
 * A 3
 */
public class aqiyi01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int P = sc.nextInt();
//        int[] food_num = new int[N];

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            map.put(i+1, sc.nextInt());
//            food_num[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            String str = sc.next();
            int index = sc.nextInt();
            if (str.equals("A")){
                int tmp = map.get(index);
                tmp++;
                map.put(index, tmp);
            }else if (str.equals("B")){
                int tmp = map.get(index);
                tmp--;
                map.put(index, tmp);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int rank = 0;
        for (Map.Entry<Integer, Integer> e : list) {
//            System.out.println(e.getKey() + ":" + e.getValue());
            rank++;
            if (e.getKey() == P){
                System.out.println(rank);
                break;
            }
        }

    }

}
