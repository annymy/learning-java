import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maxFrequency(new int[]{1,4,5}, 1, 2));
        System.out.println(solution.maxFrequency(new int[]{5,11,20,20}, 5, 1));
        System.out.println(solution.maxFrequency(new int[]{5,64}, 42, 2));
        System.out.println(solution.maxFrequency(new int[]{2}, 7, 0));
        System.out.println(solution.maxFrequency(new int[]{25,75,49}, 13, 1));
        System.out.println(solution.maxFrequency(new int[]{88,53}, 27, 2));
        System.out.println(solution.maxFrequency(new int[]{93, 45}, 1, 2));
    }
}

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int n = nums.length;

        int maxFreq = 0;
        int startIdx = 0;
        int endIdx = 0;
        int startIdx2 = 0;
        int prev = Integer.MIN_VALUE;
        int count = 0;
        int sumCount = 0;
        int sumCount2 = 0;

        for (int element:nums) {
            if(element == prev){
                count++;
            } else {
                prev = element;
                count = 1;
            }
            while(nums[startIdx]<element-k){
                sumCount--;
                startIdx++;
            }
            while (endIdx<n && nums[endIdx]<=element+k){
                sumCount++;
                endIdx++;
            }

            maxFreq = Math.max(maxFreq, count + Math.min(sumCount - count, numOperations));

            sumCount2++;
            while (nums[startIdx2]< element-2*k){
                sumCount2--;
                startIdx2++;
            }

            maxFreq = Math.max(maxFreq, Math.min(sumCount2, numOperations));
        }


        return maxFreq;
    }
}

