package samsung;

import utils.Array_To_Stack_Queue.ArrayStack;
public class Common_Ancestor {

    public static int[] getNodePath(int[] arr, int edges_num, int pNode){

        int[] from = new int[edges_num];
        int[] to = new int[edges_num];
        int index = 0;
        int i = 0;
        int[] path = new int[edges_num];
        while (i < edges_num * 2) {
            from[index] = arr[i];
            i++;
            to[index] = arr[i];
            i++;
            index++;

        }
        int max = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] > max){
                max = arr[j];
            }
        }
        max += 1;
        //初始化
        int[] right = new int[max];
        int[] left = new int[max];
        int[] parent = new int[max];
        for (int k = 1; k < max; k++) {
            right[k] = -1;
            left[k] = -1;
            parent[k] = -1;
        }



        for (int j = 0; j < from.length; j++) {
            int node = from[j];
            if (left[node] == -1){
                left[node] = to[j];
            }else {
                right[node] = to[j];
            }
        }
        for (int j = 0; j < to.length; j++) {
            parent[to[j]] = from[j];
        }
        parent[1] = -1;

        path[0] = pNode;
        int index_path = 1;
        int paren = parent[pNode];
        while (paren != -1){
            path[index_path] = paren;
            paren = parent[paren];
            index_path++;
        }
        return path;
    }

    public static int getLastComNode(int[] path1, int[] path2){
        if (path1.length < 1 || path2.length < 1){
            return 0;
        }
        int index_path1 = path1.length - 1;
        int index_path2 = path2.length - 1;
        int node = 0;
        while (index_path1 > 0 && index_path2 > 0){
            if (path1[index_path1] == path2[index_path2]){
                node = path1[index_path1];
            }
            index_path1--;
            index_path2--;
        }
        return node;
    }

    public static int getLastComParent(int[] arr, int vertices_num, int edges_num, int pNode1, int pNode2){
        if (arr.length < 1 || pNode1 < 1 || pNode2 < 1){
            return -1;
        }
        int[] tmp_path1 = getNodePath(arr, edges_num, pNode1);
        int[] tmp_path2 = getNodePath(arr, edges_num, pNode2);
        int num1 = 0;
        for (int i = 0; i < tmp_path1.length; i++) {
            if (tmp_path1[i] != 0){
                num1++;
            }
        }
        int num2 = 0;
        for (int i = 0; i < tmp_path2.length; i++) {
            if (tmp_path2[i] != 0){
                num2++;
            }
        }
        int[] path1 = new int[num1];
        for (int i = 0; i < num1; i++) {
            path1[i] = tmp_path1[i];
        }
        int[] path2 = new int[num2];
        for (int i = 0; i < num2; i++) {
            path2[i] = tmp_path2[i];
        }

        return getLastComNode(path1, path2);
    }

    public static int getTreeSize(int[] arr, int edges_num, int node){
        if (arr.length < 1 || node < 1){
            return 0;
        }

        int[] from = new int[edges_num];
        int[] to = new int[edges_num];
        int index = 0;
        int i = 0;
        while (i < edges_num * 2) {
            from[index] = arr[i];
            i++;
            to[index] = arr[i];
            i++;
            index++;

        }
        int max = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] > max){
                max = arr[j];
            }
        }
        max += 1;
        //初始化
        int[] right = new int[max];
        int[] left = new int[max];
        for (int k = 1; k < max; k++) {
            right[k] = -1;
            left[k] = -1;
        }
        for (int j = 0; j < from.length; j++) {
            int node1 = from[j];
            if (left[node1] == -1){
                left[node1] = to[j];
            }else {
                right[node1] = to[j];
            }
        }

//        Stack<Integer> stack = new Stack<>();
//        int count = 0;
//        stack.push(node);
//        while (!stack.isEmpty()){
//            int tmp = stack.pop();
//            count++;
//            if (right[tmp] != -1){
//                stack.push(right[tmp]);
//            }
//            if (left[tmp] != -1){
//                stack.push(left[tmp]);
//            }
//        }
        ArrayStack stack = new ArrayStack(edges_num);
        int count = 0;
        stack.push(node);
        while (stack.getSize() > 0){
            int tmp = stack.pop();
            count++;
            if (right[tmp] != -1){
                stack.push(right[tmp]);
            }
            if (left[tmp] != -1){
                stack.push(left[tmp]);
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int vertices_num = 13;
        int edges_num = 12;
        int[] arr = {1,2,1,3,2,4,3,5,3,6,4,7,7,12,5,9,5,8,6,10,6,11,11,13};
        int[] arr1 ={15,358,87,369,34,247,367,162,61,282,498,74,207,315,241,439,296,221,134,124,234,243,181,23,477,266,239,213,490,174,495,268,21,184,253,478,423,224,423,276,174,218,204,424,242,352,222,380,410,6,39,71,3,441,259,346,353,494,331,93,132,284,168,490,93,300,346,180,411,225,374,48,1,126,127,397,435,117,183,3,317,476,471,269,63,280,464,52,491,169,121,85,484,274,110,14,344,4,164,408,292,142,259,69,427,455,266,
                175,226,79,157,86,166,98,326,281,430,366,214,118,382,491,315,308,92,294,471,250,45,325,4,433,168,42,444,391,182,458,389,212,125,415,126,230,495,67,271,350,
                142,210,425,389,469,461,399,425,254,57,161,47,306,7,329,167,360,21,290,206,86,88,15,185,433,151,26,138,185,396,437,80,364,401,112,309,44,99,220,381,477,447,373,480,456,139,225,403,170,492,25,160,251,220,224,228,58,290,485,386,156,217,467,61,135,158,6,114,77,146,482,319,178,135,147,262,200,32,42,444,444,203,305,232,198,152,339,208,464,304,52,55,114,435,296,402,177,31,272,26,58,422,337,487,144
                ,413,30,314,249,171,469,35,403,467,36,41,427,436,213,120,229,190,321,297,23,25,111,302,130,195,326,482,439,211,144,368,30,407,462,104,400,286,190,193,297,400,202,103,260,328,171,240,400,90,282,150,120,173,197,186,208,477,166,363,377,469,174,2,270,374,327,39,428,409,439,465,496,75,252,192,249,134,11,231,323,264,460,154,24,361,52,419,12,392,445,19,50,449,172,278,349,76,13,234,1,168,265,481,284,
                72,235,303,470,453,340,95,161,337,113,443,244,411,496,310,280,165,479,191,181,464,264,457,412,466,48,426,229,271,272,295,465,209,110,28,442,46,286,60,306,127,170,148
                ,409,326,34,176,455,365,397,434,362,254,263,279,499,242,354,260,225,121,197,289,121,236,428,178,28,197,487,448,135,219,461,51,292,194,254,24,490,11,436,115,51,296,14,291,28,427,300,406,91,258,231,417,463,179,75,161,391,49,304,470,484,59,194,474,304,13,404,393,27,110,406,497,136,64,435,65,322,335,315,233,42,410,103,22,92,205,152,376,239,404,215,301,289,36,382,223,59,334,5,323,246,248,27,200,
                126,353,158,307,252,398,277,416,251,81,222,12,99,183,263,348,470,70,407,226,213,251,152,15,355,356,56,267,440,189,164,202,397,20,199,164,338,364,295,342,432,418,388,
                316,147,235,494,84,171,311,317,215,80,312,421,252,452,107,369,5,215,214,422,324,417,249,62,241,199,170,425,237,23,156,154,58,432,244,189,145,64,137,211,382,288,16,157,259,264,438,55,92,357,56,119,270,9,38,8,163,230,157,84,399,218,283,82,116,476,333,421,320,194,45,66,429,182,451,200,372,74,338,377,321,183,123,373,468,371,485,201,265,344,379,94,341,87,166,160,128,234,459,5,159,284,256,202,298,51,317,279,
                199,238,388,106,496,20,285,19,378,291,37,323,97,403,495,180,66,198,370,138,332,360,339,437,77,277,109,9,187,184,122,455,367,479,246,61,347,84,10,33,345,332,
                153,418,9,467,8,376,253,82,96,274,261,299,421,240,423,102,245,454,113,190,292,231,62,46,385,410,377,203,140,217,359,80,277,3,394,305,384,142,125,244,354,177,18,76,89,451,50,211,437,454,149,2,460,207,29,413,371,2,340,13,462,404,472,160,486,339,257,253,499,419,188,412,172,209,238,55,33,241,44,291,94,29,431,154,360,25,63,474,318,188,322,119,106,125,420,91,330,302,216,62,343,475,484,206,272,418,440,85,430,4,
                30,395,473,106,493,451,91,331,87,329,275,299,471,461,428,486,201,324,414,498,101,209,102,143,336,232,375,39,488,44,112,494,475,302,196,208,344,422,222,108
                ,390,369,144,460,27,376,313,6,331,327,207,7,111,93,349,53,155,149,287,411,141,493,479,349,357,22,452,340,147,466,136,260,500,491,355,321,498,221,454,285,405,417,34,188,182,387,329,32,131,314,483,65,54,485,177,114,130,295,105,433,288,21,229,341,273,275,129,443,446,370,306,111,17,230,181,290,383,14,119,45,305,86,442,465,263,218,293,108,412,436,450,127,299,156,108,107,445,103,133,475,83,46,53,297,82,441,43,
                358,68,137,73,189,387,338,373,257,489,419,204,289,78,7,456,348,100,406,40,353,198,88,362,242,132,370,432,413,327,204,395,88,351,357,227,101,463,362,255,
                271,143,11,239};
//        int com = getLastComParent(arr1, 500, 499, 186, 167);
        int com = getLastComParent(arr, 13, 12, 8, 13);
        System.out.println(com);
//        System.out.println(getTreeSize(arr1,499,com));
        System.out.println(getTreeSize(arr,12,com));

//        int[] path = new int[edges_num];
//        getNodePath(arr, vertices_num, edges_num, 8, path);

//        int[] right = new int[vertices_num];
//        int[] left = new int[vertices_num];
//        int i = 0;
//        int index = 0;
//        while (i < edges_num * 2) {
//            right[index] = arr[i];
//            i++;
//            left[index] = arr[i];
//            i++;
//            index++;
//        }
//        for (int j = 0; j < right.length; j++) {
//            System.out.print(right[j] + " ");
//        }
//        System.out.println();
//        for (int j = 0; j < left.length; j++) {
//            System.out.print(left[j] + " ");
//        }
    }
}
