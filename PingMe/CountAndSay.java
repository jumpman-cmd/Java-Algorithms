class Solution 
{
    public String countAndSay(int n) 
    {
        if (n <= 0) 
        {
            return "";
        }

        String current = "1";

        for (int i = 2; i <= n; i++) 
        {
            StringBuilder nextString = new StringBuilder();
            int length = current.length();
            int count = 1;

            for (int j = 0; j < length; j++) 
            {

                if (j + 1 < length && current.charAt(j) == current.charAt(j + 1)) 
                {
                    count++;
                } 
                
                else 
                {
                    nextString.append(count).append(current.charAt(j));
                    count = 1; 
                }
            }

            current = nextString.toString();
        }

        return current;
    }
}
