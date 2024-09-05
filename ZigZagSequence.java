/*
Problem Statement: Zig Zag Sequence Transformation - debug
Given an array of distinct integers, your task is to transform the array into a zig zag sequence. A sequence is called a zig zag sequence if the first half of the array is in increasing order and the second half is in decreasing order, where the middle element is considered part of the second half. You need to find the lexicographically smallest zig zag sequence by permuting the elements of the array.

You are allowed to modify at most three lines of the provided function findZigZagSequence to achieve the desired transformation.
*/

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
public class Main {
    
    public static void main (String[] args) throws java.lang.Exception {
        Scanner kb = new Scanner(System.in);
        int test_cases = kb.nextInt();
        for(int cs = 1; cs <= test_cases; cs++){
            int n = kb.nextInt();
             int a[] = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = kb.nextInt();
            }
            findZigZagSequence(a, n);
        }
   }
   
    public static void findZigZagSequence(int [] a, int n){
        Arrays.sort(a);
        int mid = (n - 1)/2; // Fixed here, changed from n+1 to n-1
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;
    
        int st = mid + 1;
        int ed = n - 2; // Also debugged here, changed from n-1 to n-2
        while(st <= ed){
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed - 1; // Also made ed to decrement.
        }
        for(int i = 0; i < n; i++){
            if(i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }
}
