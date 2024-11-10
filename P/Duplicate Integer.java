class Solution 
{
    public boolean hasDuplicate(int[] nums) 
    {
        int n = nums.length;
        boolean yes = true;
        boolean no = false;

        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if (nums[i] == nums[j])
                {
                    return yes;
                }
            }
        }

        return no;
    }
}
