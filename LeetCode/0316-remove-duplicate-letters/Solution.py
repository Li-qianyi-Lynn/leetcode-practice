class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        #set dedup
        #map let to final idx

        stack = []
        visited = set()
        char_to_idx = {}

        for idx,c in enumerate(s):
            char_to_idx[c] = idx
        
        for idx,c in enumerate(s):
            if c in visited:
                continue
            
            while stack and stack[-1] > c and idx < char_to_idx[stack[-1]]:
                temp = stack.pop()
                visited.remove(temp)

            stack.append(c)
            visited.add(c)

        return "".join(stack)
            


        