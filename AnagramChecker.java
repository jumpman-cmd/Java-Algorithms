/**
* Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.

* An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

* Example 1:

* Input: s = "racecar", t = "carrace"

* Output: true
**/

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
