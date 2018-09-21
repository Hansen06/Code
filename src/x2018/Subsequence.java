package x2018;

public class Subsequence {



    public static void main(String[] args) {
        String str = "abcd";
        StringBuilder sb = new StringBuilder();
        getSub(str, 0, sb);
    }

    private static void getSub(String str, int pos, StringBuilder sb) {
        if (pos == str.length()){
            System.out.println(sb.toString());
            return;
        }

        getSub(str, pos + 1, sb.append(str.charAt(pos)));
        sb.deleteCharAt(sb.length()-1);
        getSub(str, pos + 1, sb);
    }
}
