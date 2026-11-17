class Solution:
    def removeDuplicateLetters(self, s: str) -> str:

        le_to_idx = {} #    dict = letter -> final idx
        seen = set()
        for i,c in enumerate(s):
            le_to_idx[c] = i
        
        stack = []
        for i,c in enumerate(s):
            if c in seen:
                continue
            
            while stack and stack[-1] > c and le_to_idx[stack[-1]] > i:
                temp = stack.pop()
                seen.remove(temp)
            
            stack.append(c)
            seen.add(c)
        
        return "".join(stack)
        

    
    


        