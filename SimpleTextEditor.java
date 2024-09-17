

import java.io.*;
import java.util.*;

public class Solution 
{
    public static void main(String[] args)
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        StringBuilder s = new StringBuilder();
        Stack<String> addText = new Stack<>();
        
        for(int i = 0; i < q; i++)
        {
            int typeOfOperation = scan.nextInt();
            
            if(typeOfOperation == 1)
            {
                addText.push(s.toString());
                String w = scan.next();
                s.append(w);
            }
            
            else if(typeOfOperation ==  2)
            {
                addText.push(s.toString());
                int k = scan.nextInt();
                s.delete(s.length() - k, s.length());
            }
            
            else if(typeOfOperation == 3)
            {
                int operationIndex = scan.nextInt();
                System.out.println(s.charAt(operationIndex - 1));
            }
            
            else
            {
                if(!addText.isEmpty())
                {
                    s = new StringBuilder(addText.pop());
                }
            }
        }
        
        scan.close();
    }
}
