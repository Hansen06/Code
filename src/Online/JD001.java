package Online;

import java.util.ArrayList;
import java.util.Scanner;

public class JD001 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        if (t < 1 || t > 1000){
            return;
        }

        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < t; i++) {
//            HashMap<Integer,Integer> map = new HashMap<>();
            ArrayList<Integer> list_ou = new ArrayList<>();
            ArrayList<Integer> list_j = new ArrayList<>();

            if (arr[i]%2 != 0){
                System.out.println("No");
                continue;
            }

            if ((arr[i] & (arr[i]-1)) == 0){
                System.out.println("No");
                continue;
            }else {
                for (int j = 0; j < arr[i]; j++) {
                    if (j%2 == 0){
                        list_ou.add(j);
                    }else {
                        list_j.add(j);
                    }
                }

                int flag = 0;
                for (int j = 0; j < list_ou.size(); j++) {
                    if (flag == 0){
                        for (int k = 0; k < list_j.size(); k++) {
                            if (list_j.get(j)*list_ou.get(k) == arr[i]){
//                            map.put(list_j.get(j),list_ou.get(k));
                                System.out.println(list_j.get(j) + " " + list_ou.get(k));
                                flag = 1;
                                break;
                            }
                        }
                    }else{
                        break;
                    }
                }
                if (flag == 1){
                    flag = 0;
                }else {
                    System.out.println("No");
                }
            }
        }
    }
}
