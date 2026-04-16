import java.util.Arrays;
import java.util.Comparator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.maxRunTime(2, new int[]{3, 3, 3}));
        System.out.println(solution.maxRunTime(4, new int[]{10, 10, 5, 3}));
    }
}

class Solution {
    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);

        long total = 0;
        for(int battery:batteries){
            total+=battery;
        }
        int idx = batteries.length-1;
        while (idx>=0 && batteries[idx] > total/n){
            total-=batteries[idx];
            n--;
            idx--;
        }

        return total/n;
    }
}