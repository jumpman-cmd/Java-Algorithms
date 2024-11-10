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

// or

class Solution 
{
    public int findDuplicate(int[] nums)
    {
        int n = nums.length;
        int duplicate = 0;

        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if (nums[i] == nums[j])
                {
                    duplicate = nums[i];
                    return duplicate;
                }
            }
        }

        return -1;      
    }
}
