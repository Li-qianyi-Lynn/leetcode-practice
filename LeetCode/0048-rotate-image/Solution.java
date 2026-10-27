class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //transpose [i,j] ->[j,i]
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }

        // reverse [j,i] -> [j,n-1-i]

         for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}

/**

！try
7，4，1
8，5，2
9，6，3
i: levels; [0,n/2)
j: cell; [i, n-1-i)
 [1, 4, 7], 
 [2, 5, 8],    
 [3, 6, 9]

 

left-up: [i,j]
right-up:[i,n-1-i]
left-down
right-down

镜像+ 翻转
right up (j,n-1-i);
right buttom(n-1-i, n-1-j)
left buttom(n-1-j, i)

四角旋转+块状分割

（i，j）
（j,n-1-i）
n/2




 */