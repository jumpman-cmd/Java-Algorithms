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
