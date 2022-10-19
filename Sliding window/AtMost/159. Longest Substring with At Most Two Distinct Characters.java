public class Solution {

  /**
   * @param s: a string
   * @return: the length of the longest substring T that contains at most 2 distinct characters
   */
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    int start = 0;
    int res = 0;
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (!map.containsKey(c)) {
        map.put(c, 0);
      }
      if (map.get(c) == 0) count++;
      map.put(c, map.get(c) + 1);
      while (count > 2) {
        char ch = s.charAt(start);
        map.put(ch, map.get(ch) - 1);
        if (map.get(ch) == 0) count--;
        start++;
      }
      res = Math.max(res, i - start + 1);
    }
    return res;
  }
}
