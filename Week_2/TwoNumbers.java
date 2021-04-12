//两数之和
public class TwoNumbers{
	public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int t1 = target - nums[i];
            if(map.containsKey(t1)){
                return new int[]{i,map.get(t1)};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
