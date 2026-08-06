package Two_Pointers;

import java.util.*;

public class Two_Pointers {
    public static List<int[]> twoSum(int[] nums, int target) {
        List<int[]> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                result.add(new int[] {complement, nums[i]});
            }
            
            map.put(nums[i], i);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        List<int[]> pairs = twoSum(nums, target);
        
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }
    }
}
