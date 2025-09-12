cur.append(digit.charAt(i));
DFS(digits, index + 1, myMap, cur, myList);
cur.deleteCharAt(cur.length() - 1);