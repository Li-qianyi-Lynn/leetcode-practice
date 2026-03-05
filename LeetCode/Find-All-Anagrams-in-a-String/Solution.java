public class Solution {
    public IList<int> FindAnagrams(string s, string p) {
        var pLength = p.Length;
        var result = new List<int>();
        var pString = Conversion(p);

        for(var i = 0; i <= s.Length-pLength; i++) {
            var builder = new StringBuilder();
            for(var j = i; j < pLength+i; j++) {
              builder.Append(s[j]);
            }
            if( Conversion(builder.ToString()) == pString) result.Add(i);
        }
        
        return result;
    }
    
    public string Conversion(string tmp) {
        var mapper = new int[26];
        for(var i = 0; i < tmp.Length; i++) {
            var index = tmp[i] - 'a';
            mapper[index] += 1;
        }
        var stringBuilder = new StringBuilder();
        for(var i = 0; i < mapper.Length; i++) {
            stringBuilder.Append(mapper[i].ToString());
        }
        
        return stringBuilder.ToString();
    }
}