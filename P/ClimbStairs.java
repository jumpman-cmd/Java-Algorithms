class Solution 
{
    public int climbStairs(int n) 
    {
        int first = 1, second = 2;

        if (n <= 2)
        {
            return n;
        }    

        else
        {
            for (int i = 3; i <= n; i++)
            {
                int third = first + second;
                first = third;
                second = first;
            }
        }

        return second;
    }
}
