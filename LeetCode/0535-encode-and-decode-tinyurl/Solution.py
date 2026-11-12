class Codec:
    def __init__(self):
        self.charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        self.url_map = {}
        self.count_id = 1

    def encode_base62(self, num):
        if num == 0:
            return self.charset[0]
        res = [] # to string later
        while num > 0:
            idx = num % 62
            res.append(self.charset[idx])
            num = num // 62
        
        return "".join(reversed(res))

    def encode(self, longUrl: str) -> str:
        """Encodes a URL to a shortened URL.
        """
        short_code = self.encode_base62(self.count_id)
        self.count_id += 1
        self.url_map[short_code] = longUrl
        return "http://tinyurl.com/" + short_code

    def decode(self, shortUrl: str) -> str:
        """Decodes a shortened URL to its original URL.
        """
        short_code = shortUrl.rstrip().split("/")[-1]
        return self.url_map[short_code]

        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(url))