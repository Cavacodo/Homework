package AlgorithemHomework;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,7,9};
        Arrays.sort(nums);
        int[] t = search(nums,0);
        System.out.println(""+t[0]+","+t[1]);
    }
    public static int[] search(int[] nums,int target){
        int[] ans = new int[2];
        int len = nums.length;
        int left = 0, right = len-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                ans[0] = mid;
                ans[1] = mid;
                return ans;
            }
            if(nums[mid]<target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        ans[0] = right;
        ans[1] = left;
        return ans;
    }
}
