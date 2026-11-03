class Codec:
    def __init__(self):
        self.short_dict = {}
        self.count_id = 1
        self.charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"

    def encode_base62(self, num) -> str:
        if num == 0:
            return self.charset[0]
        res = [] # later join to string
        while num > 0:
            idx = num % 62
            res.append(self.charset[idx])
            num = num // 62
        return ''.join(reversed(res))

            
    def encode(self, longUrl: str) -> str:
        """Encodes a URL to a shortened URL.
        """
        # longurl->short code 
        short_code = self.encode_base62(self.count_id)
        self.count_id +=1
        self.short_dict[short_code] = longUrl
        # build short url: http://tinyurl.com/ + code
        return "http://tinyurl.com/" +  short_code

    def decode(self, shortUrl: str) -> str:
        """Decodes a shortened URL to its original URL.
        """
        short_code = shortUrl.split("/")[-1]
        return self.short_dict[short_code]
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(url))
