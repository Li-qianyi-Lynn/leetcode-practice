class Solution:
    def isValid(self, s: str) -> bool:
        # 创建一个哈希表/字典，存储右括号到左括号的映射
        # 这有助于快速查找匹配的左括号
        mappings = {
            ')': '(',
            ']': '[',
            '}': '{'
        }

        # 使用列表作为栈
        stack = []

        # 遍历输入字符串中的每个字符
        for char in s:
            # 如果当前字符是右括号
            if char in mappings:
                # 检查栈是否为空，如果为空，则 pop() 会报错
                # 如果不为空，则弹出栈顶元素，否则使用一个哑元值'#'，确保不匹配
                top_element = stack.pop() if stack else '#'
                
                # 检查弹出的左括号是否与当前右括号匹配
                if mappings[char] != top_element:
                    return False
            else:
                # 如果当前字符是左括号，直接压入栈中
                stack.append(char)
        
        # 循环结束后，如果栈为空，说明所有括号都匹配了
        # 如果栈不为空，说明有未匹配的左括号
        return not stack