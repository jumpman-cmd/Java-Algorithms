class Solution 
{
    public int findMaxLength(int[] nums) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int n = nums.length;
        int maxLength = 0;
        int contigousNum = 0;

        for (int i = 0; i < n; i++)
        {
            contigousNum += (nums[i] == 0) ? -1 : 1;

            if (map.containsKey(contigousNum))
            {
                maxLength = Math.max(maxLength, i - map.get(contigousNum));
            }

            else
            {
                map.put(contigousNum, i);
            }
        }    

        return maxLength;
    }
}
