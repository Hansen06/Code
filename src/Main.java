import Design_Pattern.TicketMaker;
import Design_Pattern.TicketMaker1;
import Offer.Solution001_Find;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
//        TicketMaker ticketMaker = TicketMaker.getInstance();
//        for (int i = 0; i < 3; i++) {
//            System.out.println(ticketMaker.getNextTicketNumber());
//        }
//
//        TicketMaker ticketMaker1 = TicketMaker.getInstance();
//        for (int i = 0; i < 3; i++) {
//            System.out.println(ticketMaker1.getNextTicketNumber());
//        }
//
        TicketMaker1 ticketMaker = new TicketMaker1();
        for (int i = 0; i < 3; i++) {
            System.out.println(ticketMaker.getNextTicketNumber());
        }

        System.out.println("==============================");
        TicketMaker1 ticketMaker1 = new TicketMaker1();
        for (int i = 0; i < 3; i++) {
            System.out.println(ticketMaker1.getNextTicketNumber());
        }

    }
}
