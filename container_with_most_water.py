import numpy as np

class Solution:
    def maxArea(self, height):
        N = len(height)
        D = np.zeros((N, N))
        for i in range(N):
            for j in range(i, N):
                if i == j:
                    continue
                D[i][j] = self.calculate_area(i, j, height)
                D[j][i] = self.calculate_area(i, j, height)
        return int(np.amax(D))


    def calculate_area(self, i, j, height):
        length = abs(i - j)
        height = min(height[i], height[j])
        return length * height
