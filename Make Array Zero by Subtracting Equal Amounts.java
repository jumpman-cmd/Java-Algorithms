class Solution
{
    public int minimumOperations(int[] nums)
    {
        Set<Integer> count = new HashSet<>();

        for (int num : nums)
        {
            if (num > 0)
            {
                count.add(num);
            }
        }

        return count.size();
    }
}
