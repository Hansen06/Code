package Design_Pattern;

public class TicketMaker1 {
    private int ticket = 1000;
    public int getNextTicketNumber(){
        return ticket++;
    }
}
