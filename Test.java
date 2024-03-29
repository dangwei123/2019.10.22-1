1.
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

请找出其中最小的元素。

你可以假设数组中不存在重复元素。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int mid=0;
        while(left<right){
            mid=left+(right-left)/2;
            if(nums[mid]<nums[right]){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return nums[left];
    }
}

2.
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。

编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public boolean search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return true;
                }
           if(nums[mid]==nums[left]){
                left++;
               continue;
            }
             if(nums[mid]>nums[left]){
                if(target>=nums[left]&&target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if(target<=nums[right]&&nums[mid]<target){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return false;
    }
}