import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(solution.fourSum(new int[]{2, 2, 2, 2, 2}, 8));
        System.out.println(solution.fourSum(new int[]{-1000000000, -1000000000, 1000000000, -1000000000, -1000000000}, 294967296));
        System.out.println(solution.fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0));
    }
}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> quadruplets = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i+1 && nums[j] == nums[j - 1]) continue;
                int idxLeft = j + 1, idxRight = nums.length - 1;
                while (idxLeft < idxRight) {
                    long currentSum = (long)nums[idxLeft] + nums[idxRight] + nums[j]+ nums[i];
                    if (currentSum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[idxLeft], nums[idxRight], nums[j]));
                        while (idxLeft < idxRight && nums[idxLeft] == nums[idxLeft + 1]) idxLeft++;
                        while (idxLeft < idxRight && nums[idxRight] == nums[idxRight - 1]) idxRight--;
                        idxLeft++;
                        idxRight--;
                    } else if (currentSum > target) {
                        idxRight--;
                    } else {
                        idxLeft++;
                    }
                }
            }
        }
        return quadruplets;
    }
}