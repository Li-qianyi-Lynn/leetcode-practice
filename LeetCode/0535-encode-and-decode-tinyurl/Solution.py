class Codec:
    def __init__(self):
        self.url_dic = {} #short code -> long url
        self.char_set = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        self.id_counter = 1

    def encode_base62(self, num) -> str:
        if num == 0:
            return self.char_set[0]
        
        res = []
        while num > 0:
            idx = num % 62
            res.append(self.char_set[idx])
            num = num // 62
        
        return ''.join(reversed(res))

    def encode(self, longUrl: str) -> str:
        """Encodes a URL to a shortened URL.

        """
        #long -> short
        short_code = self.encode_base62(self.id_counter)
        #update dict
        self.url_dic[short_code] = longUrl
        #incremental id
        self.id_counter+=1
        #return 
        return "http://tinyurl.com/" + short_code

        
        
    def decode(self, shortUrl: str) -> str:
        """Decodes a shortened URL to its original URL.
        """
        short_code =  shortUrl.split("/")[-1]
        return self.url_dic[short_code]
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(url))