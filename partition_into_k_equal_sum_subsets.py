import numpy as np


class Graph:
    def __init__(self, root, nums):
        self.root = root
        self.nums = nums

    def get_next_states(self, curr_state):
        if curr_state == self.root:
            neighbour_index = 0

        else:
            index = curr_state.index
            neighbour_index = index + 1 if index + 1 < len(self.nums) else None

        if neighbour_index == None:
            return None

        inclusive_neighbour = State(curr_state.score + self.nums[neighbour_index], curr_state, neighbour_index, True)
        exclusive_neighbour = State(curr_state.score, curr_state, neighbour_index, False)
        return inclusive_neighbour, exclusive_neighbour

    def backtrack(self, curr_state):
        included_indices = []
        while curr_state is not self.root:
            if curr_state.included:
                included_indices.append(curr_state.index)
            curr_state = curr_state.from_state
        return included_indices


class State:
    def __init__(self, score, from_state, index, included):
        self.score = score
        self.from_state = from_state
        self.index = index
        self.included = included


class Solution:
    def canPartitionKSubsets(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        # if we can partition into k equal subsets, we know that the sum of all elements in the list / k = sum of elements in each partition
        # therefore we can get goal by sum_elements / k
        subset_sum = np.sum(nums) / k
        nums = sorted(nums)[::-1]
        if nums[0] > subset_sum:
            return False
        return self.recursively_partition_k_subsets(nums, subset_sum, k)
        # if there is an element larger than what we wish to split the elements into, we know that it is impossible
        return True

    def recursively_partition_k_subsets(self, nums, target, k):

    def remove_indices(self, indices, nums):
        for index in indices:
            print("element removed", nums[index])
            del nums[index]
        print("_________________")
        return nums

    def subset_sum(self, nums, target):
        if not nums:
            return [], False
        root = State(0, None, None, True)
        graph = Graph(root, nums)
        child1, child2 = graph.get_next_states(root)
        to_visit_first = [child1]
        to_visit_second = [child2]
        while len(to_visit_first) + len(to_visit_second) != 0:
            if to_visit_first:
                curr_node = to_visit_first.pop(0)
            else:
                curr_node = to_visit_second.pop()

            if curr_node.score == target:
                elems = graph.backtrack(curr_node)
                nums = self.remove_indices(elems, nums)
                return nums, True

            next_states = graph.get_next_states(curr_node)

            if next_states is not None:
                to_visit_first.append(next_states[0])
                to_visit_second.append(next_states[1])

        return nums, False


def test():
    nums = [4, 5, 9, 3, 10, 2, 10, 7, 10, 8, 5, 9, 4, 6, 4, 9]
    k = 5
    sol = Solution()
    sol.canPartitionKSubsets(nums, k)


test()
