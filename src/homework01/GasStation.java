package homework01;

/**
 * gas-station
 */
public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length != cost.length || gas == null || cost == null) {
            return -1;
        }
        int start = 0;
        int sum = 0;
        int total = 0;
        for (int i = 0; i < gas.length; ++i) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        return (total >= 0) ? start : -1;
    }

    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        if (gas.length != cost.length || gas == null || cost == null) {
            return -1;
        }
        int start = gas.length -1 ;
        int sum = gas[start] - cost[start];
        int end = 0;
        while (start > end){
           if (sum >= 0){
               sum += gas[end] - cost[end];
               ++end;
           }else {
               --start;
               sum += gas[start] - cost[start];
           }
        }
        return (sum >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] gas = {2};
        int[] cost = {2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

}
