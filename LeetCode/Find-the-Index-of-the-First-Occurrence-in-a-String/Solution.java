for i = 1 to m-1
  for k = 0 to i
     if needle[0..k-1] == needle[i-(k-1)..i]
       longest_border[i] = k