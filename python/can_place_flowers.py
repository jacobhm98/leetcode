class Solution:
    def canPlaceFlowers(self, flowerbed, n):
        max_plant_count = self.plant_greedily(flowerbed)
        if n <= max_plant_count:
            return True
        return False

    def plant_greedily(self, flowerbed):
        last_neighbour_empty = True
        max_planted = 0
        for i, bed in enumerate(flowerbed):
            if last_neighbour_empty and (i == len(flowerbed) - 1 or flowerbed[i + 1] == 0):
                if bed == 1:
                    last_neighbour_empty = False
                    continue
                flowerbed[i] = 1
                max_planted += 1
                last_neighbour_empty = False
            elif flowerbed[i] == 0:
                last_neighbour_empty = True
            else:
                last_neighbour_empty = False
        return max_planted

def test():
    n = 2
    flowerbed = [1, 0, 0, 0, 0, 1]
    sol = Solution()
    sol.canPlaceFlowers(flowerbed, n)

test()