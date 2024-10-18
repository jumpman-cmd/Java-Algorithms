/*
Maximum Subarray
Solved

Given an array of integers nums, find the subarray with the largest sum and return the sum.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [2,-3,4,-2,2,1,-1,4]

Output: 8

Explanation: The subarray [4,-2,2,1,-1,4] has the largest sum 8.

Example 2:

Input: nums = [-1]

Output: -1

Constraints:

    1 <= nums.length <= 1000
    -1000 <= nums[i] <= 1000
*/

class MaximumSubarray 
{
    public int maxSubArray(int[] nums) 
    {
        int totalSum = nums[0];
        int currSum = nums[0];
        int n = nums.length;

        for(int i = 1; i < n; i++)
        {
            currSum = Math.max(nums[i], currSum + nums[i]);
            totalSum = Math.max(totalSum, currSum);
        }       

        return totalSum;
    }
}