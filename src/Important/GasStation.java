package Important;

/**
 * Created by yuliu on 9/5/16.
 * 有N个gas stations
 * 每个station i的gas amount用 gas[i]表示
 * cost[i] represents the gas to travel from station i to its next station i + 1.
 *
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasLeft = 0;
        int gasNeed = 0;
        int start = 0;//一开始从0开始
        for (int i = 0; i < gas.length; i++) {
            gasLeft += gas[i] - cost[i];
            if (gasLeft < 0) {
                gasNeed -= gasLeft;
                gasLeft = 0;
                start = i;
            }
        }
        return gasLeft >= gasNeed ? start : -1;
    }
}
