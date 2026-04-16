import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[]nums = {3, 1};
        System.out.println(countMaxOrSubsets(nums));

        int[] nums2 = {2,2,2};
        System.out.println(countMaxOrSubsets(nums2));

        int[] nums3 = {3,2,1,5};
        System.out.println(countMaxOrSubsets(nums3));
    }

    public static int countMaxOrSubsets(int[] nums) {
        int or = 0;
        for (int num : nums) {
            or |= num;
        }

        int n = nums.length;
        int count = 0;

        for (int mask = 1; mask < (1<<n); mask++) {
            int currentOr = 0;
            for (int i = 0; i < n; i++) {
                if((mask&(1<<i))!=0){
                    currentOr|=nums[i];
                }
            }
            if(currentOr==or){
                count++;
            }

        }

        return  count;
    }
}
