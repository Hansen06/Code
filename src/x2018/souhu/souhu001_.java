package x2018.souhu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class souhu001_ {

    public static void getMap(char[] ch, HashMap<Character, Integer> map, HashSet<Character> set) {
        for (int i = 0; i < ch.length; i++) {
            if (map.containsKey(ch[i])) {
                map.put(ch[i], map.get(ch[i]) + 1);
            } else {
                map.put(ch[i], 1);
            }
            set.add(ch[i]);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str1 = in.next();
            String str2 = in.next();

            if (str1.equals(str2)){
                System.out.println("0");
            }else {

                if (str1.length() != str2.length()) {
                    System.out.println("0");
                } else {
                    char[] ch1 = str1.toCharArray();
                    char[] ch2 = str2.toCharArray();
                    HashMap<Character, Integer> map1 = new HashMap<>();
                    HashSet<Character> set1 = new HashSet<>();
                    getMap(ch1, map1, set1);

                    HashSet<Character> set2 = new HashSet<>();
                    HashMap<Character, Integer> map2 = new HashMap<>();
                    getMap(ch2, map2, set2);
                    if (set1.size() != set2.size()) {
                        System.out.println("0");
                    } else {
                        boolean flag = true;
                        for (Character key : map1.keySet()) {
                            if (map1.get(key) != map2.get(key)) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            for (Character key : map2.keySet()) {
                                if (map1.get(key) != map2.get(key)) {
                                    System.out.println("0");
                                    break;
                                }
                            }
                            System.out.println("1");
                        } else {
                            System.out.println("0");
                        }
                    }
                }
            }
        }

    }
}
