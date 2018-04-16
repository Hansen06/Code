package Online;

import java.util.HashMap;

public class Te {

    public static void main(String[] args) {

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,3);
        map.put(3,4);

        System.out.println(map.get(1));

        System.out.println("----------");
        for (int i = 0; i < map.size(); i++) {
            System.out.println(map.get(i));
        }


        System.out.println("===================");
        int bit = 0;
        bit = bit<<1;
//        bit = bit<<1;
        System.out.println(bit);

    }
}
