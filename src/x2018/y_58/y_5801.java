package x2018.y_58;

import java.util.ArrayList;

public class y_5801 {

    public static String[][][] strToArray(String str, String[] splitStrArray){

        if (str == null || splitStrArray == null){
            return null;
        }

        String[] s1 = str.split(splitStrArray[0]);
        ArrayList<ArrayList<ArrayList<String>>> res = new ArrayList<>();
        for (int i = 0; i < s1.length; i++) {
            String[] s11 = s1[i].split(splitStrArray[1]);
            ArrayList<ArrayList<String>> a11 = new ArrayList<>();
            for (int j = 0; j < s11.length; j++) {
                String[] s111 = s11[j].split(splitStrArray[2]);
                ArrayList<String> a111 = new ArrayList<>();
                for (int k = 0; k < s111.length; k++) {
                    a111.add(s111[k]);
                }
                a11.add(a111);
            }
            res.add(a11);
        }
        for (int i = 0; i < res.size(); i++) {
            ArrayList<ArrayList<String >> a1 = res.get(i);
            for (int j = 0; j < a1.size(); j++) {
                ArrayList<String> a2 = a1.get(j);
                for (int k = 0; k < a2.size(); k++) {
                    System.out.print(a2.get(k) + " ");
                }
                System.out.println();
            }
        }
        return  null;
    }

    public static void main(String[] args) {
        String str = "a:1#b:2#c:3@x:8#y:9#z:10";
        String[] split = {"@","#",":"};
        strToArray(str, split);

    }
}
