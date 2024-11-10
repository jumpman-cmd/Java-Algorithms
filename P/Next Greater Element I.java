class Solution 
{
    public int[] nextGreaterElement(int[] nums1, int[] nums2)
    {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++)
        {
            int count = nums1[i];
            int nextGE = -1; // next greater element

            int j = 0;
            while (j < m && nums2[j] != count)
            {
                j++;
            }

            for (int k = j + 1; k < m; k++)
            {
                if (nums2[k] > count)
                {
                    nextGE = nums2[k];
                    break;
                }
            }

            ans[i] = nextGE;
        }

        return ans;
    }
}
