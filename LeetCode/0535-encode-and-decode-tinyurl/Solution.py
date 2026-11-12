class Codec:
    def __init__(self):
        self.char_set ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        self.count = 1
        self.short_to_ori = {}


    def encode_base62(self, num):
        if num <= 0:
            return None
        
        res = [] #to string
        while num > 0:
            idx = num % 62
            res.append(self.char_set[idx])
            num = num // 62
        return "".join(reversed(res))
    
    def encode(self, longUrl: str) -> str:
        """Encodes a URL to a shortened URL.
        """
        short_code = self.encode_base62(self.count)
        self.count += 1
        self.short_to_ori[short_code] = longUrl

        return "http://tinyurl.com/" + short_code

        

    def decode(self, shortUrl: str) -> str:
        """Decodes a shortened URL to its original URL.
        """
        short_code = shortUrl.rstrip().split("/")[-1]
        return self.short_to_ori[short_code]
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(url))