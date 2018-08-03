package samsung;

public class Order_of_task {

    public static int[] getOrderOfTask(int[] arr, int vertices_num, int edges_num){
        if (arr.length < 1){
            return null;
        }

        int[] order = new int[vertices_num + 1];

        int[] from = new int[edges_num];
        int[] to = new int[edges_num];
        int i = 0;
        int index = 0;
        while (i < arr.length){
            from[index] = arr[i];
            i++;
            to[index] = arr[i];
            i++;
            index++;
        }

        int[] in_degree = new int[vertices_num + 1];
        int[][] next = new int[vertices_num + 1][vertices_num + 1];
        for (int j = 1; j < vertices_num + 1; j++) {
            for (int k = 0; k < vertices_num + 1; k++) {
                next[j][k] = -1;
            }
        }

        for (int j = 0; j < vertices_num; j++) {
            in_degree[to[j]]++;
        }

        for (int j = 1; j < vertices_num + 1; j++) {
            System.out.print(in_degree[j] + " ");
        }

        System.out.println();
        for (int j = 0; j < vertices_num; j++) {
            int node = from[j];
            int ind = 0;
            int flag = 0;
            for (int k = flag; k < vertices_num; k++) {
                if (from[k] == node){
                    next[node][ind] = to[k];
                    ind++;
                }
            }
            flag++;
        }
//        for (int j = 1; j < vertices_num + 1; j++) {
//            for (int k = 0; k < vertices_num + 1; k++) {
//                if (next[j][k] != -1){
//                    System.out.print(next[j][k] + " ");
//                }
//            }
//            System.out.println();
//        }

        int index_order = 0;
        while (index_order < vertices_num) {
            for (int j = 1; j < in_degree.length; j++) {
                if (in_degree[j] == 0) {
                    order[index_order] = j;
                    for (int k = 0; k <= next[j].length; k++) {
                        if (next[j][k] != -1) {
                            in_degree[next[j][k]]--;
                            next[j][k] = -1;
                        } else {
                            break;
                        }
                    }
                    in_degree[j]--;
                    index_order++;
                }
            }
        }
        return order;
    }
    public static void main(String[] args) {
        int vertices_num = 9;
        int edges_num = 9;
        int[] arr = {4,1,1,2,2,3,2,7,5,6,7,6,1,5,8,5,8,9};
        int[] order = new int[vertices_num];
        order = getOrderOfTask(arr, vertices_num, edges_num);
        for (int i = 0; i < vertices_num; i++) {
            if (order[i] != 0){
                System.out.print(order[i] + " ");
            }
        }
    }

}
