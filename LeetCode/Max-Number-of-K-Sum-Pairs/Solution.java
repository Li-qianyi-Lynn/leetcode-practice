class Solution:
    def maxOperations(self, nums: List[int], k: int) -> int:
        freq = Counter(nums)
        count = 0
        for i in list(freq.keys()):
            x = freq.pop(i)
            j = k - i
            if i == j:
                count += x // 2
            elif j in freq:
                count += min(x, freq[j])
        return count