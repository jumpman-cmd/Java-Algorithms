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

public class Solution 
{
    public static void main(String[] args) 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int numberOfOperations = scan.nextInt();
        
        Stack<Integer> quStack1 = new Stack<>();
        Stack<Integer> quStack2 = new Stack<>();
        
        for(int i = 0; i < numberOfOperations; i++)
        {
            int typeOfOperation = scan.nextInt();
            if(typeOfOperation == 1)
            {
                int x = scan.nextInt();
                quStack1.push(x);
            }
            
            else if(typeOfOperation == 2)
            {
                if(quStack2.isEmpty())
                {
                    while(!quStack1.isEmpty())
                    {
                        quStack2.push(quStack1.pop());
                    }
                }
                
                quStack2.pop();
            }
            
            else
            {
                if(typeOfOperation == 3)
                {
                    if(quStack2.isEmpty())
                    {
                        while(!quStack1.isEmpty())
                        {
                            quStack2.push(quStack1.pop());
                        }
                    }
                }
                
                System.out.println(quStack2.peek());
            }
        }
        
        scan.close();
    }
}
