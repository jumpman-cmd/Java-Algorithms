class Solution
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        Set<List<Integer>> tis = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                for (int k = j + 1; k < n; k++)
                {
                    if (nums[i] + nums[j] + nums[k] == 0)
                    {
                        List<Integer> newList = Arrays.asList(nums[i], nums[j], nums[k]);
                        tis.add(newList);
                    }
                }
            }
        }

        return new ArrayList<>(tis);
    }
}
