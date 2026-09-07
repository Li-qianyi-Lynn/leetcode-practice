class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        c = collections.Counter(nums1) & collections.Counter(nums2)
        ans = []
        for k, v in c.items():
            ans.extend([k] * v)
        return ans