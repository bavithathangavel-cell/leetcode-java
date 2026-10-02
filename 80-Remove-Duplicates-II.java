class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int length = nums.size();
        int newLength = length; // Will keep track of the valid array length
        int counter = 0;        // Counts occurrences of current number
        int num = nums[0];      // Initialize with the first number
        
        // Traverse through the array
        for (int i = 0; i < length; i++) {
            if (nums[i] == num) {
                counter++;
                // If more than two occurrences, mark as invalid
                if (counter >= 3) {
                    nums[i] = INT_MAX;
                    newLength--;
                }
            } else {
                // New number, reset counter
                num = nums[i];
                counter = 1;
            }
        }
        // Move invalid INT_MAXs to the end by sorting
        sort(nums.begin(), nums.end());
        return newLength; // The first newLength entries are valid
    }
};
