/*
Implement a simple text editor that supports the following operations:
    Append: Append a given string to the end of the current text.
    Delete: Delete the last k characters from the current text.
    Print: Print the character at a given 1-based index.
    Undo: Undo the last append or delete operation and revert the text to its previous state.

Input Format:
    The first line contains an integer q, the number of operations.
    The next q lines describe the operations in one of the following formats:
        1 w: Append the string w to the text.
        2 k: Delete the last k characters from the text.
        3 k: Print the k-th character of the text (1-based index).
        4: Undo the last append or delete operation.

Output Format:
    For each 3 k operation, output the k-th character of the text.

Constraints:
    The sum of the lengths of all w across all append operations does not exceed 106106.
    The sum of k across all delete operations does not exceed 106106.
    It is guaranteed that the sequence of operations is valid.
*/

// This code is correct, but it doesn't pass all test cases, it passes 14/15 test cases
// Meaning there's only 1 test case that doesn't pass. I will work it through, I'll update when I figured the solution.

// Also when working on this problem; you can use a switch instead of if-else statements.

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

// Using a switch statement
// The switch passes 13/15 test cases. Meaning two cases don't successfuly pass this code.

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
            switch(typeOfOperation)
            {
                case 1:
                {
                    addText.push(s.toString());
                    String w = scan.next();
                    s.append(w);
                    break;
                }   
                
                case 2:
                {
                    addText.push(s.toString());
                    int k = scan.nextInt();
                    s.delete(s.length() - k, s.length());
                    break;
                }
                
                case 3:
                {
                    int operationIndex = scan.nextInt();
                    System.out.println(s.charAt(operationIndex - 1));
                    break;
                }
                
                case 4:
                {
                    if(!addText.isEmpty())
                    {
                        s = new StringBuilder(addText.pop());
                        break;
                    }
                }
            }
        }
        
        scan.close();
    }
}
