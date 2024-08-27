class AnagramChecker 
{
    public boolean isAnagram(String s, String t) 
    {
        int nS = s.length();
        int tS = t.length();
        int[] counts = new int[26];

        if(nS != tS)
        {
            return false;
        }

        for(int i = 0; i < nS; i++)
        {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        for(int j = 0; j < 26; j++)
        {
            if(counts[j] != 0)
            {
                return false;
            }
        }
        return true;
    }
}
