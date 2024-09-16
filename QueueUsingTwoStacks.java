/*

*/

import java.io.*;
import java.util.*;

public class QueueUsingTwoStacks 
{
    public static void main(String[] args) 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner count = new Scanner(System.in);
        int numberOfOperations = count.nextInt();
        
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        for(int i = 0; i < numberOfOperations; i++)
        {
            int typeOfOperation = count.nextInt();
            
            if(typeOfOperation == 1)
            {
                int addToQu = count.nextInt();
                stack1.push(addToQu);
            }
            
            else if(typeOfOperation == 2)
            {
                if(stack2.isEmpty())
                {
                    while(!stack1.isEmpty())
                    {
                        stack2.push(stack1.pop());
                    }
                }
                
                stack2.pop();
            }
            
            else
            {
                if(typeOfOperation == 3 && stack2.isEmpty())
                {
                    while(!stack1.isEmpty())
                    {
                        stack2.push(stack1.pop());
                    }
                }
                
                System.out.println(stack2.peek());
            }
        }
        
        count.close();
    }
}
