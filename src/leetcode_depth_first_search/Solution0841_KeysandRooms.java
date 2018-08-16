package leetcode_depth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Keys and Rooms
 */
public class Solution0841_KeysandRooms {

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms.size() == 0){
            return true;
        }
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        boolean[] isGet = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (!isGet[cur]) {
                isGet[cur] = true;
                List<Integer> list = rooms.get(cur);
                for (int i = 0; i < list.size(); i++) {
                    queue.add(list.get(i));
                    if (!visited[list.get(i)]) {
                        visited[list.get(i)] = true;
                    }
                }
            }
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
//        l1.add(3);

        List<Integer> l2 = new ArrayList<>();
        l2.add(2);
//        l2.add(0);
//        l2.add(1);

        List<Integer> l3 = new ArrayList<>();
        l3.add(3);

        List<Integer> l4 = new ArrayList<>();
//        l4.add(0);

        List<List<Integer>> l = new ArrayList<>();
        l.add(l1);
        l.add(l2);
        l.add(l3);
        l.add(l4);

        System.out.println(canVisitAllRooms(l));
    }
}
