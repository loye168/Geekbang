 /**
@Descriptor 全排列_2
@auth luoye
@Date 2021-4-14 23:40:12
**/
public class FullArrangementTwo{
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        helper(res, nums, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] nums, int loc) {
        if (loc == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = loc; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                swap(nums, i, loc);
                helper(res, nums, loc + 1);
                swap(nums, i, loc);
            }
        }
    }
    //交换位置
    private void swap(int[] nums, int loc1, int loc2) {
        if (loc1 != loc2) {
            nums[loc1] += nums[loc2];
            nums[loc2] = nums[loc1] - nums[loc2];
            nums[loc1] -= nums[loc2];
        }
    } 
 }
 