/**
* Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.

* You may assume that every input has exactly one pair of indices i and j that satisfy the condition.

* Return the answer with the smaller index first.

* Example 1:

* Input: 
* nums = [3,4,5,6], target = 7

* Output: [0,1]
**/

class TwoIntegerSum 
{
    public int[] twoSum(int[] nums, int target) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
        {
            int nPoints = target - nums[i];

            if(map.containsKey(nPoints))
            {
                return new int[] {map.get(nPoints), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}
