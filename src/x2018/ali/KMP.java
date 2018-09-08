package x2018.ali;

import java.util.*;

public class KMP {

    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
        int si = 0;
        int mi = 0;
        int[] next = getNextArray(ms);
        while (si < ss.length && mi < ms.length) {
            if (ss[si] == ms[mi]) {
                si++;
                mi++;
            } else if (next[mi] == -1) {
                si++;
            } else {
                mi = next[mi];
            }
        }
        return mi == ms.length ? si - mi : -1;
    }

    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String order = sc.next();
        String[] all = input.split(";");
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < all.length; i++) {
            String[] arr = all[i].split("_");
            map.put(arr[0], arr[1]);
        }

        for (String name : map.keySet()) {
            if(name.equals("song")) {
                String[] cur = map.get("song").split("\\|");
                Arrays.sort(cur);
                StringBuilder sb = new StringBuilder();
                ArrayList list = new ArrayList();
                for (int j = cur.length - 1; j >= 0; j--) {
                    int index = getIndexOf(order, cur[j]);
                    if (!list.contains(index)) {
                        list.add(index);
                        if (index != -1) {
                            sb.append(order.substring(0, index));
                            sb.append(" ");
                            sb.append(order.substring(index, index + cur[j].length()));
                            sb.append("/" + "song");
                            sb.append(" ");
                            sb.append(order.substring(index + cur[j].length(), order.length()));
                        }
                    }
                }
                order = sb.toString();
            }else if (name.equals("singer")){
                String[] cur = map.get("singer").split("\\|");
                Arrays.sort(cur);
                StringBuilder sb = new StringBuilder();
                ArrayList list = new ArrayList();
                for (int j = cur.length - 1; j >= 0; j--) {
                    int index = getIndexOf(order, cur[j]);
                    if (!list.contains(index)) {
                        list.add(index);
                        if (index != -1) {
                            sb.append(order.substring(0, index));
                            sb.append(" ");
                            sb.append(order.substring(index, index + cur[j].length()));
                            sb.append("/" + "singer");
                            String[] act = map.get("actor").split("\\|");
                            for (int i = 0; i < act.length; i++) {
                                if ((order.substring(index, index + cur[j].length())).equals(act[i])) {
                                    sb.append("," + "actor");
                                }
                            }
                            sb.append(" ");
                            sb.append(order.substring(index + cur[j].length(), order.length()));
                        }
                    }
                }
                order = sb.toString();
            }
        }
        System.out.println(order);
    }

}
