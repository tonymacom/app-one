package com.tony.unit;

import java.util.Arrays;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2018/12/27
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
public class QuickSort {

    public static void main(String[] args) {
        int array[] = {49,38,65,97,76,13,27,49};
        quickSort(array,0,7);
    }


    public static void quickSort(int arr[],int low,int high){
        int l=low;
        int h=high;
        int povit=arr[low];

        while(l<h){
            while(l<h&&arr[h]>=povit){
                h--;
            }
            if(l<h){
                int temp=arr[h];
                arr[h]=arr[l];
                arr[l]=temp;
                l++;
            }

            while(l<h&&arr[l]<=povit){
                l++;
            }

            if(l<h){
                int temp=arr[h];
                arr[h]=arr[l];
                arr[l]=temp;
                h--;
            }
        }
        print(arr);
        System.out.print("l="+(l+1)+",h="+(h+1)+",povit="+povit+"\n");
        if(l>low){
            quickSort(arr,low,l-1);
        }
        if(h<high){
            quickSort(arr,l+1,high);
        }
    }

    private static void print(int[] arr) {
        for (int i:arr) {
            System.out.print(i+",");
        }
        System.out.println();
    }

}
