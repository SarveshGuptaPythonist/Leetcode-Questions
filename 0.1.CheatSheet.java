// Gives total count where sum is greater than targets
public int twoSumGreater(int[] numbers, int left, int right, int target) {
        int count = 0;
        while(left < right) {
            int ans = numbers[left] + numbers[right];
            if(ans > target) {
                count+=right-left;
                right--;
            }
            else {
                left++;
            }
        }
        return count;
    }
// Two sum give count of total Targets
public int twoSum(int[] numbers, int left, int right, int target) {
        int count = 0;
        while(left < right) {
            int ans = numbers[left] + numbers[right];
            if(ans == target) {
                count++;
                left++;
                right--;
            }
            else if(ans > target) {
                right--;
            }
            else{
                left++;
            }
        }
        return count;
    }
// Two SUm optimized
public List<List<Integer>> twoSum(int[] nums, int left, int right, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int start = left;
        while(left < right) {
            if(left > start && nums[left-1] == nums[left]) {
                left++; continue;
            }
            int sum = nums[left] + nums[right];
            
            if(ans == target) {
                    // System.out.println(i + " " + left + " " + right);
                    List<Integer> currRes = new ArrayList<>();
                    currRes.add(nums[left]);
                    currRes.add(nums[right]);
                    ans.add(new ArrayList<>(currRes));
                    left++;
                    right--;
                    
                    
                }
                else if(ans > target){
                    right--;
                }
                else{
                    left++;
                }
        }
        return ans;
    }
// GCD
static int gcd(int a, int b) {
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }

// Binary Search
class Solution {
    public int search(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}

// Binary Search UpperBound and LowerBound
import java.io.*;
import java.util.*;

public class Main{

// Combination of ceil and first occurence
public static int lowerBound(int[] arr, int target){
    int left = 0, right = arr.length - 1;
    int ans = arr.length;
    
    while(left <= right){
        int mid = left + (right - left) / 2;
        
        if(arr[mid] >= target){
            ans = mid;
            right = mid - 1;
        }
        else {
            left = mid + 1;
        }
    }
    return ans;
}

// This is nothing but ceil
public static int upperBound(int[] arr, int target){
    int left = 0, right = arr.length - 1;
    while(left <= right){
        int mid = left + (right - left) / 2;
        
        if(arr[mid] <= target) 
            left = mid + 1;
        else right = mid - 1;
    }
    return left;
}

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i=0; i<n; i++){
        arr[i] = scn.nextInt();
    }
    
    int target = scn.nextInt();
    System.out.println(lowerBound(arr, target));
    System.out.println(upperBound(arr, target));  
 }

}
