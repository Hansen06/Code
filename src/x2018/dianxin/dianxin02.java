package x2018.dianxin;

public class dianxin02 {

    public static void main(String[] args) {
        int a, b, c, t1, t2;
        for (a = 0; a <= 9; a++) {
            for (b = 0; b <= 9; b++) {
                for (c = 0; c <= 9; c++) {
                    for (int d = 0; d <= 9; d++) {
                        t1 = a * 1000 + b * 100 + c * 10 + d;
                        t2 = b * 1000 + c * 100 + d * 10 + a;
                        if (t1 + t2 == 8888) {
                            System.out.println(a + " " + b + " " + c + " " + d);
                        }
                    }
                }
            }
        }

    }

}
