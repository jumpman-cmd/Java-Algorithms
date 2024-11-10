class Solution 
{
    public int[] nextGreaterElement(int[] nums1, int[] nums2)
    {
        int[] count = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++)
        {
            int cur = nums1[i];
            int nextGreater = -1;

            int j = 0;
            while (j < nums2.length && nums2[j] != cur)
            {
                j++;
            }

            for (int k = j + 1; k < nums2.length; k++)
            {
                if (nums2[k] > cur)
                {
                    nextGreater = nums2[k];
                    break;
                }
            }

            count[i] = nextGreater;
        }

        return count;
    }
}
