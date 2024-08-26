class HasDuplicate
{
    public boolean hasDuplicate(int[] nums) 
    {
        boolean duplicate = true;
        int N = nums.length;

        for(int i = 0; i < N - 1; i++)
        {
            for(int j = i + 1; j < N; j++)
            {
                if(nums[i] == nums[j])
                {
                    duplicate = true;
                }
                
                else
                {
                    duplicate = false;
                }
            }
        }
        return duplicate;
    }
}
