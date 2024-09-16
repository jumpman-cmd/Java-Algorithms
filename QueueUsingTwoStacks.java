/*
Problem Statement: Implement a Queue Using Two Stacks
The task is to implement a queue using two stacks. A queue follows a First-In-First-Out (FIFO) structure, 
where elements are enqueued at the rear and dequeued from the front. The program will process a series of queries that either enqueue an element, 
dequeue an element, or print the element at the front of the queue.

Implement must follow three types of queries:
    1 x: Enqueue element x into the end of the queue.
    2: Dequeue the element from the front of the queue.
    3: Print the element at the front of the queue.

Input:
    The first line contains an integer q (the number of queries).
    Each of the following q lines contains a query of one of the three types mentioned above.

Output:
    For each query of type 3, print the element at the front of the queue.

Constraints:
    It is guaranteed that all dequeue and print operations will be valid, i.e., the queue will never be empty when such operations are performed.
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
