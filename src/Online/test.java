package Online;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();

            System.out.println(n/(m*2)*m*m);

        }

    }
}
