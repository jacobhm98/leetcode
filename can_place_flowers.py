class Solution:
    def canPlaceFlowers(self, flowerbed, n):
        maximally_planted_flowerbed = self.plant_greedily(flowerbed)
        max_count = 0
        for bed in maximally_planted_flowerbed:
            if bed == 1:
                max_count += 1
        if max_count >= n:
            return True
        return False

    def plant_greedily(self, flowerbed):
        last_neighbour_empty = True
        for i, bed in enumerate(flowerbed):
            if last_neighbour_empty and (i == len(flowerbed) - 1 or flowerbed[i + 1] == 0):
                flowerbed[i] = 1
                last_neighbour_empty = False
            elif flowerbed[i] == 0:
                last_neighbour_empty = True
            else:
                last_neighbour_empty = False
        return flowerbed