package x2018;

public class Test {
    public static void main(String[] args) {
        char[] arr = {'a','b'};
//        System.out.println(new String(arr));
//        System.out.println(String.valueOf(arr));

        String str = "8.9";
        String[] str1 = str.split("/.");
        System.out.println(str1[1]);
    }
}
