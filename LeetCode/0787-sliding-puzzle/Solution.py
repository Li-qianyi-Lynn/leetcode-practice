class Solution:
    def slidingPuzzle(self, board: list[list[int]]) -> int:
        target = "123450"
        chars = []
        for r in board:
            for num in r:
                chars.append(str(num))
        start = "".join(chars)

        if start == target:
            return 0

        
        neighbors = { # tuple 可以直接用下标访问 t[0]
            0:(1,3),
            1:(0,2,4),
            2:(1,5),
            3:(0,4),
            4:(1,3,5),
            5:(2,4)
        }

        queue = deque([(start,0)])
        visited = {start}

        while queue:
            state, steps = queue.popleft()

            if state == target:
                return steps

            zero_idx = state.index('0')

            for next_idx in neighbors[zero_idx]:
                # swap num
                state_list = list(state)
                state_list[zero_idx], state_list[next_idx] = state_list[next_idx], state_list[zero_idx]
                next_state = "".join(state_list)
                if next_state not in visited:
                    queue.append((next_state, steps+1))
                    visited.add(next_state)
        
        return -1

        