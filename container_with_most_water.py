import numpy as np

class Solution:
    def maxArea(self, height):
        max_area = []
        p1, p2 = 0, len(height) - 1
        while p1 < p2:
            curr_area = (p2 - p1) * min(height[p1], height[p2])
            max_area.append(curr_area)

            #if limiting height is p1, change it
            if height[p1] <= height[p2]:
                p1 += 1
            #else limiting height is p2
            else:
                p2 -= 1
        max_area = sorted(max_area)
        #pick out last element of sorted list, which is therefore the largest element
        return max_area[-1]
