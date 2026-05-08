class Solution(object):
    def addStrings(self, num1, num2):
        def convert(c): 
            return ord(c)-ord('0')
       
        x1=x2=0    
        for i in num1:
            x1=x1*10 + convert(i)
        for j in num2:
            x2=x2*10 + convert(j)
        x=x1+x2
        
        return str(x)