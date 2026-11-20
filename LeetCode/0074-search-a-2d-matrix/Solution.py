class Solution:
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        row = len(matrix)
        col = len(matrix[0])

        l = 0
        r = row * col -1

        while l <= r:
            mid = (l + r) // 2
            x= mid // col
            y = mid % col

            if matrix[x][y] == target:
                return True
            elif matrix[x][y] < target:
                l = mid +1
            else:
                r = mid -1
        
        return False
        