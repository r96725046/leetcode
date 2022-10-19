public class Solution {

  /**
   * @param s: A string
   * @param k: An integer
   * @return: An integer
   */
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    if (s.length() == 0) return 0;
    HashMap<Character, Integer> map = new HashMap<>();

    int count = 0;
    int start = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!map.containsKey(c)) map.put(c, 0);

      if (map.get(c) == 0) count++;
      map.put(c, map.get(c) + 1);

      while (count > k) {
        c = s.charAt(start);
        map.put(c, map.get(c) - 1);
        if (map.get(c) == 0) count--;
        start++;
      }
      max = Math.max(max, i - start + 1);
    }
    return max;
  }
}
