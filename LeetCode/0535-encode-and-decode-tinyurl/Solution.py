class Codec:
    def __init__(self):
        self.url_map = {}
        self.id_count = 1
        self.charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"

    def encode_base62(self, num) -> str:
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
        1. id -> short_code 
        2. update url_map + update id
        3. make short url
        """
        #1. id -> short_code 
        short_code = self.encode_base62(self.id_count)

        #2. update url_map + update id
        self.id_count+=1
        self.url_map[short_code] = longUrl

        #3. make short url
        return "http://tinyurl.com/" + short_code

        

    def decode(self, shortUrl: str) -> str:
        """Decodes a shortened URL to its original URL.
        """
        # get the short_code 
        short_code = shortUrl.split("/")[-1]

        # return original url by map
        return self.url_map[short_code]
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(url))