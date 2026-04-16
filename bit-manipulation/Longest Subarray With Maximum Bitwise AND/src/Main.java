//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 2, 2};
        System.out.println(longestSubarray(nums));

        int[] nums2 = {1, 2, 3, 4};
        System.out.println(longestSubarray(nums2));

        int[] nums3 = {1, 2, 3, 3, 2, 2};
        System.out.println(longestSubarray(nums3));

        int[] nums4 = {311155, 311155, 311155, 311155, 311155, 311155, 311155, 311155, 201191, 311155};
        System.out.println(longestSubarray(nums4));

        int[] nums5 = {96317, 96317, 96317, 96317, 96317, 96317, 96317, 96317, 96317, 279979};
        System.out.println(longestSubarray(nums5));


    }

    public static int longestSubarray(int[] nums) {
        int maxValue = Integer.MIN_VALUE;

        int current = 0;
        int maxCount = 0;
        int count = 0;

        if (nums.length < 2) {
            return nums.length;
        } else {
            //int prev = nums[current];
            while (current < nums.length) {
                int next = nums[current];
                if (next == maxValue) {
                    count++;
                } else if (next>maxValue) {
                    maxValue = next;
                    count = 1;
                    maxCount = 1;
                } else {
                    count = 0;
                }
                if(count>maxCount){
                    maxCount = count;
                }
                current++;
                //prev = next;
            }
        }

        return maxCount;
    }
}