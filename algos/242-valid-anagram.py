class Solution(object):
  def isAnagram(self, s, t):
    hashset = {}
    
    if len(t) != len(s):
        return False

    for val in s:
        if val in hashset:
            hashset[val] += 1
        else:
            hashset[val] = 1
    
    for val in t:
        if val in hashset and hashset[val] > 0:
            hashset[val] -= 1
        else:
            return False
            
    return True