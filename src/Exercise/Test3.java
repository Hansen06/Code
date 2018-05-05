package Exercise;

public class Test3 {
    public static void main(String[] args) {
//        String perfer;
//        System.out.println("perfer = " + perfer);

        Integer integer = 128;
        Integer integer1 = 128;
        System.out.println((integer == integer1) + ",");
        String string = "100";
        String string1 = "1" + new String("00");
        String string2 = "100";
        System.out.println((string == string1) + ",");
        System.out.println((string == string2) + ",");

        Integer i5 = 100;
        Integer i6 = 100;
        System.out.println((i5 == i6) + ",");

        System.out.println(1+2+"3"+4+5);
    }
}
