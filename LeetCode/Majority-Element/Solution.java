class Solution {
public:
    int majorityElement(vector<int>& nums) {
        unordered_map<int, int> hash;
        auto size = nums.size() / 2;
        for (auto i: nums){
            ++hash[i];
            if (hash[i] > size) return i; // Here I thought I would exit way before reaching N
        }
        throw;
    }
};