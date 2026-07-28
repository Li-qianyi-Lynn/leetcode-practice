def __init__(self):
        self.ledger = [-1]
        self.jump = dict()
        
    def next(self, price: int) -> int:
        # add price to ledger and add entry for jump
        self.ledger.append(price)
        p_idx = len(self.ledger)-1
        if p_idx == 1:
            return 1 # first entry
        
        # check previous val
        prev = self.ledger[p_idx-1]
        prev_idx = p_idx-1
        
        if prev <= price:
            while prev <= price and prev_idx > 0:
                if prev_idx in self.jump:
                    prev_idx = self.jump[prev_idx]
                else:
                    prev_idx -= 1
                prev = self.ledger[prev_idx]
            self.jump[p_idx] = prev_idx+1
            return p_idx-prev_idx
        else:
            return 1