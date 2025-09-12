    def carFleet(self, target, position, speed):
        n = len(speed)
        arrivals = [(target-position[i])/speed[i] for i in range(n)]
        data = sorted(list(zip(arrivals, position)), reverse=True)
        count = 0
        curr_max = -1
        for ch in data:
            if ch[1]>curr_max:
                curr_max=ch[1]
                count+=1
        return count