/*
 * @lc app=leetcode id=287 lang=cpp
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start
class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int size = nums.size();
        int l = 1, h = size-1;
        while(l <= h) {
            int mid = l + (h-l)/2;
            int cnt = 0;
            for (size_t i = 0; i < size; i++){
                if(nums[i] <= mid) ++cnt;
            }
            if(cnt <= mid) l = mid + 1;
            else h = mid - 1;
        }
        return l;
    }
};
// @lc code=end

