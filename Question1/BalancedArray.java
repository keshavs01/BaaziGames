package com.example.demo2.Question1;

public class BalancedArray {

    public int balancedSum(int[] arr) {
        int totalSum = 0;
        int leftSum = 0;
        for(int i=0;i<arr.length;i++)
            totalSum+=arr[i];

        for(int i=0;i<arr.length;i++){
            if(leftSum == totalSum-arr[i]-leftSum)
                return i;
            leftSum+=arr[i];
        }
        return -1;
    }
}
