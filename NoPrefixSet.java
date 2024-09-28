/*
No Prefix Set

You are given a list of strings consisting only of lowercase letters. A set of strings is considered a GOOD SET if no string in the set is a prefix of another string. 
If any string is a prefix of another, print BAD SET followed by the first offending string.

Input
    The first line contains an integer n (1 ≤ n ≤ 100,000), the number of strings.
    The next n lines each contain a string words[i] (1 ≤ |words[i]| ≤ 100), composed of lowercase letters.

Output
    Print GOOD SET if the strings form a good set.
    If there is a bad set, print BAD SET followed by the offending string on the next line.
*/

import java.io.*;
import java.util.*;

class BranchNode 
{
    Map<Character, BranchNode> next = new HashMap<>();
    boolean isEndOfWord = false;
}

class Result 
{
    /*
     * Complete the 'noPrefix' function below.
     *
     * The function accepts STRING_ARRAY words as parameter.
     */
     
     public static void noPrefix(List<String> words) 
     {
         BranchNode root = new BranchNode();
         
         for (String word : words) 
         {
             BranchNode curNode = root;
             boolean isBadSet = false;
             int n = word.length();
             
             for (int i = 0; i < n; i++) 
             {
                 char ch = word.charAt(i);
                 
                 if(curNode.isEndOfWord) 
                 {
                     System.out.println("BAD SET");
                     System.out.println(word);
                     return;
                 }
                 
                 curNode = curNode.next.computeIfAbsent(ch, k -> new BranchNode());
             }
             
             if(!curNode.next.isEmpty() || curNode.isEndOfWord)
             {
                 System.out.println("BAD SET");
                 System.out.println(word);
                 return;
             }
             
             curNode.isEndOfWord = true;
         }
         
         System.out.println("GOOD SET");
    }
}

public class NoPrefixSet 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) 
        {
            words.add(bufferedReader.readLine());
        }

        Result.noPrefix(words);

        bufferedReader.close();
    }
}
