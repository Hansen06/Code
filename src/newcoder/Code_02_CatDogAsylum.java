package newcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 猫狗收容所
 */
public class Code_02_CatDogAsylum {


    public static class EnterQueue {
        private Integer pet;
        private long count;

        public EnterQueue(Integer pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Integer getPet() {
            return this.pet;
        }

        public long getCount() {
            return this.count;
        }
    }

    public static ArrayList<Integer> asylum(int[][] ope) {

        ArrayList<Integer> result = new ArrayList<>();
        Queue<EnterQueue> catQ;
        Queue<EnterQueue> dogQ;
        int count = 0;

        catQ = new LinkedList<EnterQueue>();
        dogQ = new LinkedList<EnterQueue>();

        for (int i = 0; i < ope.length ; i++) {
            if (ope[i][0] == 1){
                if (ope[i][1] > 0){
                    dogQ.add(new EnterQueue(ope[i][1], count++));
                }else{
                    catQ.add(new EnterQueue(ope[i][1], count++));
                }
            }

            if (ope[i][0] == 2){
                if (ope[i][1] == 0){
                    if (!catQ.isEmpty() && !dogQ.isEmpty()){
                        if (dogQ.peek().getCount() < catQ.peek().getCount()){
                            result.add(dogQ.poll().getPet());
                        }else {
                            result.add(catQ.poll().getPet());
                        }
                    }else if(!dogQ.isEmpty()){
                        result.add(dogQ.poll().getPet());
                    }else if(!catQ.isEmpty()){
                        result.add(catQ.poll().getPet());
                    }else{

                    }
                }else if (ope[i][1] == 1){
                    if (!dogQ.isEmpty()){
                        result.add(dogQ.poll().getPet());
                    }
                }else if (ope[i][1] == -1){
                    if (!catQ.isEmpty()){
                        result.add(catQ.poll().getPet());
                    }
                }else {

                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] arr = {{1,1},{1,-1},{2,0},{2,-1}};
        ArrayList<Integer> result = new ArrayList<>();
        result = asylum(arr);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

}
