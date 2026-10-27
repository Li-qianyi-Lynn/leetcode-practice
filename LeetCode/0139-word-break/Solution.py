class Solution:
    def wordBreak(self, s: str, wordDict: list[str]) -> bool:
        word_set = set(wordDict)
        n = len(s)
        q = deque([0])
        visited = set()
        visited.add(0)
        while q:
            start = q.popleft()
            if start == n:
                return True

            for end in range(start+1, n+1):
                if end in visited:
                    continue
                if s[start:end] in word_set:
                    q.append(end)
                    visited.add(end)
        return False
        
        