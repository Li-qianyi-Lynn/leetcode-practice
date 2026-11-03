class Codec:
    def __init__(self):
        self.url_map = {} #short_code -> long_url
        self.id_counter = 1
        self.charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"

    def encode_base62(self,num) -> str:
        if num == 0:
            return self.charset[0]
        res = [] # join to string
        while num > 0:
            idx = num % 62
            res.append(self.charset[idx])
            num = num // 62
        
        return ''.join(reversed(res))

    
    def encode(self, longUrl: str) -> str:
        """Encodes a URL to a shortened URL.
        1. id -> shortcode base62
        2. update url_map, update id
        3. build shorturl
        """
        short_code = self.encode_base62(self.id_counter)
        self.id_counter += 1
        self.url_map[short_code] = longUrl
        return "http://tinyurl.com/" + short_code
        

    def decode(self, shortUrl: str) -> str:
        """Decodes a shortened URL to its original URL.
        """
        short_code = shortUrl.split("/")[-1]
        return self.url_map[short_code]
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(url))
